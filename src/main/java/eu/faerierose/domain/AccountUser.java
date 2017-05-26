package eu.faerierose.domain;

import javax.persistence.Column;


import javax.persistence.Entity;

@Entity
public class AccountUser extends Account {
	@Column(unique=true, nullable=false)
	private String username;
	private String password;
	private String passwordHint;


	public AccountUser() {
		this.setSession(null);
	}

	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	/* =================================================================== */
	@Override
	public String clarifyPassword() {
		return this.password;
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
