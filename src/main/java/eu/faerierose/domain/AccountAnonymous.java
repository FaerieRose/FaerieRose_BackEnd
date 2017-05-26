package eu.faerierose.domain;

import javax.persistence.Entity;

@Entity
public class AccountAnonymous extends Account {
	public AccountAnonymous() {
		this.setUsername("anonymous" + (int)(10000 + Math.random() * 90000));
		this.setFirstname("");
		this.setSurname("");
		this.addRole("ROLE_ANONYMOUS");
	}
	
	@Override
	public String acquireUsername() {
		return "anonymous";
	}
	
	@Override
	public String clarifyPassword() {
		return "";
	}
}
