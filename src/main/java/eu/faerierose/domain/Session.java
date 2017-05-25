package eu.faerierose.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	@OneToOne(fetch=FetchType.EAGER)
	private Account account;

	public Session(String code, String time, Date date, Account account) {
		this.setAccount(account);
		this.setCreationTime(date);
		this.setSessionKey(code + time);
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
	private void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	/* =================================================================== */
	public Date getCreationTime() {
		return creationTime;
	}
	private void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	/* =================================================================== */
	public Account getAccount() {
		return account;
	}
	private void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
