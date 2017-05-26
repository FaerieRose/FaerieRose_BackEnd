package eu.faerierose.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author FaerieRose
 * @since 2017-05-24
 */
@Entity
public class Account extends Person {
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Role> roles;
	@OneToOne(fetch=FetchType.EAGER)
	Session session;
	
	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public String getUsername() { return null; };
	/* =================================================================== */
	public String clarifyPassword() { return null; };
	/* =================================================================== */
	public Set<Role> getRoles() {
		return roles;
	}
	public String[] getRolesAsStringArray() {
		String[] roleArray = new String[roles.size()];
		Role[] rls = roles.toArray(new Role[] {});
		for (int i=0; i<roles.size() ; i++) { 
			roleArray[i] = rls[i].getName();
			System.out.println(roleArray[i]);
		}
		return roleArray;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}


/*
INSERT INTO `account` (`dtype`, `id`, `birth_date`, `email`, `firstname`, `blob_pictogram`, `surname`, `password`, `password_hint`, `username`, `crazy`, `session_id`) VALUES ('AccountUser', NULL, NULL, NULL, 'Kyara', NULL, 'Hardy', 'test678', NULL, 'Enya', NULL, NULL);
INSERT INTO `account` (`dtype`, `id`, `firstname`,  `surname`, `password`, `username`) VALUES 
('AccountUser', NULL, 'Rosalynn', 'Hardy', 'unknown', 'FaerieRose'),
('AccountUser', NULL, 'Kyara', 'Hardy', 'test678', 'Enya'),
('AccountUser', NULL, 'Arwen', 'Hardy', 'test123', 'Gaya'),
('AccountUser', NULL, 'Robin', 'Hardy', 'test260', 'Ramses');

 */
