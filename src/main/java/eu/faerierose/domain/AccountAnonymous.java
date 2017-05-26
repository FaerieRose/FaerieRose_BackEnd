package eu.faerierose.domain;

public class AccountAnonymous extends Account {
	
	

	public String getUsername() {
		return "anonymous";
	}
	
	@Override
	public String clarifyPassword() {
		return "";
	}

}
