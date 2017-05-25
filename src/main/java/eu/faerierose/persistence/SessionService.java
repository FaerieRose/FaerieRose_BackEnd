package eu.faerierose.persistence;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.faerierose.domain.Account;
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
		this.sessionRepository.delete(id);
	}
	
	public String newSessionKey(String clientTime, String username) {
		System.out.println("\n=============== in newSessionKey()");
		Account account = this.accountService.findByUsername(username);
		if (account == null) return null;
		if (account.getSession() != null) {
			System.out.println("=============== in newSessionKey() - delete Session = " + account.getSession().getId());
			this.deleteSessionKeyById(account.getSession().getId());
			account.setSession(null);
			this.accountService.save(account);
		}
		long rndId = (long) (Math.random() * 100.0);
		Code code = this.codeRepository.findOne(rndId);
		Session session = new Session(code.getCode(), clientTime, new Date(), account);
		this.sessionRepository.save(session);
		account.setSession(session);
		this.accountService.save(account);
		return session.getSessionKey();
	}
}
