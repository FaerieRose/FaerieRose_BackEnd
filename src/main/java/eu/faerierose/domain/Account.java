package eu.faerierose.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

/**
 * 
 * @author FaerieRose
 * @since 2017-05-24
 */
@Entity
public class Account extends Person {
	@Column(unique=true, nullable=false)
	private String username;
	private String password;
	private String passwordHint;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Role> roles;

	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	/* =================================================================== */
	public String clarifyPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	/* =================================================================== */
	public String getPasswordHint() {
		return passwordHint;
	}
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

}


/*

INSERT INTO `account` (`id`, `birth_date`, `email`, `firstname`, `blob_pictogram`, `surname`, `password`, `password_hint`, `username`) VALUES 
(NULL, NULL, NULL, 'Rosalynn', NULL, 'Hardy', 'unknown', NULL, 'FaerieRose'),
(NULL, NULL, NULL, 'Robin', NULL, 'Hardy', 'test260', NULL, 'Ramses'),
(NULL, NULL, NULL, 'Arwen', NULL, 'Hardy', 'test123', NULL, 'Gaya'), 
(NULL, NULL, NULL, 'Kyara', NULL, 'Hardy', 'test678', NULL, 'Enya');

 */
