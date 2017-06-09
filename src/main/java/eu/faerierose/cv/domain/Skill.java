package eu.faerierose.cv.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author FaerieRose
 * @since 2017-06-09
 */
@Table(name="CV__SKILL")
@Entity
public class Skill extends Entry {
	private String level;

	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	
}
