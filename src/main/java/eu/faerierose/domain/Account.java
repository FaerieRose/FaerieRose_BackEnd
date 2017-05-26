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
public abstract class Account extends Person {
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Role> roles;
	@OneToOne(fetch=FetchType.EAGER)
	Session session;
	
	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public abstract String getUsername();
	/* =================================================================== */
	public abstract String clarifyPassword();
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

INSERT INTO `account` (`id`, `birth_date`, `email`, `firstname`, `blob_pictogram`, `surname`, `password`, `password_hint`, `username`, `session_id`) VALUES 
(NULL, NULL, NULL, 'Rosalynn', NULL, 'Hardy', 'unknown', NULL, 'FaerieRose', NULL),
(NULL, NULL, NULL, 'Robin', NULL, 'Hardy', 'test260', NULL, 'Ramses', NULL),
(NULL, NULL, NULL, 'Arwen', NULL, 'Hardy', 'test123', NULL, 'Gaya', NULL), 
(NULL, NULL, NULL, 'Kyara', NULL, 'Hardy', 'test678', NULL, 'Enya', NULL);

 */
