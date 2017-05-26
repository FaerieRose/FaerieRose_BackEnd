package eu.faerierose.domain;

import javax.persistence.Entity;

@Entity
public class AccountAnonymous extends Account {
	private int crazy;
	

	@Override
	public String getUsername() {
		return "anonymous";
	}
	
	@Override
	public String clarifyPassword() {
		return "";
	}

	public int getCrazy() {
		return crazy;
	}

	public void setCrazy(int crazy) {
		this.crazy = crazy;
	}

	
	
}
