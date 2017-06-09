package eu.faerierose.cv.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author FaerieRose
 * @since 2017-06-09
 */
@Table(name="CV__WORK_EXPERIENCE")
@Entity
public class WorkExperience extends Entry {
	private String function;
	private String description;
	private String location;
	@OneToOne(fetch=FetchType.EAGER)
	private Employer employer;

	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	/* =================================================================== */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/* =================================================================== */
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	/* =================================================================== */
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	
	
}
