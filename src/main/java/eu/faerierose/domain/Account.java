package eu.faerierose.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * 
 * @author FaerieRose
 * @since 2017-05-24
 */
@Entity
public abstract class Account extends Person {
	@Column(unique=true, nullable=false)
	String username;
	
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> roles = new ArrayList<>();
	@OneToOne(fetch=FetchType.EAGER)
	Session session;
	

	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public void setUsername(String username) {
		this.username = username;
	}	
	public String getUsername() {
		return username;
	}
	/* =================================================================== */
	public abstract String clarifyPassword();
	/* =================================================================== */
	public List<String> getRoles() {
		return roles;
	}
	public String[] getRolesAsStringArray() {
		String[] roleArray = new String[roles.size()];
		for (int i=0; i<roles.size() ; i++) { 
			roleArray[i] = roles.get(i);
		}
		return roleArray;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public void addRole(String role) { 
		this.roles.add(role);
	}
}


/*

INSERT INTO `account` (`dtype`, `id`, `firstname`,  `surname`, `password`, `username`) VALUES 
('AccountUser', NULL, 'Rosalynn', 'Hardy', 'unknown', 'FaerieRose'),
('AccountUser', NULL, 'Kyara', 'Hardy', 'test678', 'Enya'),
('AccountUser', NULL, 'Arwen', 'Hardy', 'test123', 'Gaya'),
('AccountUser', NULL, 'Robin', 'Hardy', 'test260', 'Ramses');
INSERT INTO `account` (`dtype`, `id`, `firstname`,  `surname`, `username`) VALUES 
('AccountAnonymous', NULL, '-', '-', 'anonymous');

 */
