package eu.faerierose.domain;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import eu.faerierose.SessionEncryption;

/**
 * 
 * @author FaerieRose
 * @since 2017-05-25
 */
@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique=true, nullable=false, length=16)
	private String sessionKey;
	private Date creationTime;
	@OneToOne(fetch=FetchType.EAGER, mappedBy = "session")
	private Account account;

	public Session() {}
	public Session(String code, String time, Date date, Account account) {
		if (account != null) {
			this.setAccount(account);
		}
		this.setCreationTime(date);
		this.setSessionKey(code, time);
	}
	
	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/* =================================================================== */
	public String getSessionKey() {
		return sessionKey;
	}
	private void setSessionKey(String code, String time) {
		String key = SessionEncryption.generateSessionKey(code, time);
		if (this.account == null) {
			System.out.println("=============== NEW sessionKey = " + key + "   : anonymous");
		} else {
			System.out.println("=============== NEW sessionKey = " + key + "   : username" + account.getUsername());
		}
		this.sessionKey = key;
	}
	/* =================================================================== */
	public Date getCreationTime() {
		return creationTime;
	}
	private void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	/* =================================================================== */
	public String getAccount() {
		if (account != null) {
			return account.getUsername();
		}
		return null;
	}
	public Account acquireAccount() {
		return account;
	}
	private void setAccount(Account account) {
		if (account.getUsername().equals("anonymous")) {
			this.account = null;
		} else {
			this.account = account;
		}
	}
	
	
	
}
