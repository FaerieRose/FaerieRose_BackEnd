package eu.faerierose.domain;

import javax.persistence.Entity;

import eu.faerierose.SessionEncryption;

@Entity
public class AccountUser extends Account {
	private String password;
	private String passwordHint;

	/* =================================================================== */
	@Override
	public String clarifyPassword() {
		String result = SessionEncryption.calculatePaswordCode(this.password, this.getSession().getSessionKey());
		return result;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/* =================================================================== */
	public Session getSession() {
		return this.session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	/* =================================================================== */
	public String getPasswordHint() {
		return passwordHint;
	}
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}
	
}
