package eu.faerierose.persistence;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.faerierose.domain.Account;
import eu.faerierose.domain.AccountAnonymous;
import eu.faerierose.domain.AccountUser;
import eu.faerierose.domain.Code;
import eu.faerierose.domain.Session;

@Service
@Transactional
public class SessionService {

	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	CodeRepository codeRepository;

	@Autowired
	AccountService accountService;
	
	public Session findById(Long id) {
		return this.sessionRepository.findOne(id);
	}
	
	public Session findBySessionKey(String key) {
		Iterable<Session> sessions = this.sessionRepository.findAll();
		for (Session session: sessions) {
			System.out.println(session.getSessionKey());
			if (session.getSessionKey().equals(key)) {
				return session;
			}
		}
		return null;
	}
	
	public void deleteSessionKeyById(Long id) {
		Session session = this.sessionRepository.findOne(id);
		if (session.getAccount() == null) {
			System.out.println("=============== DEL sessionKey = " + session.getSessionKey() + "   : anonymous");
		} else {
			System.out.println("=============== DEL sessionKey = " + session.getSessionKey() + "   : username" + session.getAccount().getUsername());
		}
		this.sessionRepository.delete(id);
	}
	
	public String newSessionKey(String clientTime, String username) {
		this.cleanUpSessionKeys();
		long rndId = (long) (Math.random() * 100.0);
		Code code = this.codeRepository.findOne(rndId);
		Date now = new Date();
		Account account = this.accountService.findAccount(username);
		if (account instanceof AccountUser) {
			AccountUser user = this.accountService.findByUsername(username);
			if (user.getSession() != null) {
				this.deleteSessionKeyById(user.getSession().getId());
				user.setSession(null);
				this.accountService.save(user);
			}
			Session session = new Session(code.getCode(), clientTime, now, user);
			this.sessionRepository.save(session);
			user.setSession(session);
			this.accountService.save(user);
			return session.getSessionKey();
		} else if (account instanceof AccountAnonymous) {
			Session session = new Session(code.getCode(), clientTime, now, null);
			this.sessionRepository.save(session);
			((AccountAnonymous)account).addSession(session);
			this.accountService.save(account);
			return session.getSessionKey();
		}
		return null;
	}

	private void cleanUpSessionKeys() {
		// CleanUp sessionKeys that have no account and are not in anonymous list
		Iterable<Session> sessions = this.sessionRepository.findAll();
		for (Session session: sessions) {
			if (session.getAccount() == null) {
				this.deleteSessionKeyByIdAnoymous(session.getId(), false);
			}
		}
		// CleanUp sessionKeys that are too old
		sessions = this.sessionRepository.findAll();
		Date now = new Date();
		for (Session session: sessions) {
			if (session.getAccount() == null) {
				long diff = (now.getTime() - session.getCreationTime().getTime());
				System.out.println("=============== Diff time " + diff/60000);
				diff /= 60000;
				if (diff  > 60) {
					this.deleteSessionKeyByIdAnoymous(session.getId(), true);
				}
			}
		}
	}
	
	private void deleteSessionKeyByIdAnoymous(long id, boolean inList) {
		boolean found = false;
		Session session;
		AccountAnonymous account = ((AccountAnonymous) this.accountService.findAccount("anonymous"));
		List<Session> accSessions = account.getSessions();
		for (int i=0 ; i<accSessions.size() ; i++) {
			if (accSessions.get(i).getId() == id) {
				session = accSessions.get(i);
				if (inList) {
					account.removeSession(session);
					this.deleteSessionKeyById(id);
				}
				found = true;
				break;
			}
		}
		if (!found && !inList) {
			this.deleteSessionKeyById(id);
		}
	}
	
}
