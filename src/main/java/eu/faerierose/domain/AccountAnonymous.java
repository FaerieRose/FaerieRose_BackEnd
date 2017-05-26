package eu.faerierose.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class AccountAnonymous extends Account {
	@OneToMany
	private List<Session> sessions = new ArrayList<>();

	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	@Override
	public String clarifyPassword() {
		return "";
	}
	/* =================================================================== */
	public List<Session> getSessions() {
		return sessions;
	}
	public void addSession(Session session) {
		this.sessions.add(session);
	}
	public void removeSession(Session session) {
		this.sessions.remove(session);
	}
	
	
}
