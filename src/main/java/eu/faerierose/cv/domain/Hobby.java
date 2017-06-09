package eu.faerierose.cv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Brief description of a hobby 
 * @author FaerieRose
 * @since 2017-06-08
 */
@Table(name="CV__HOBBY")
@Entity
public class Hobby {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String description;

	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/* =================================================================== */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/* =================================================================== */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
