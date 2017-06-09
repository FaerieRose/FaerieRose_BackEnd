package eu.faerierose.cv.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author FaerieRose
 * @since 2017-06-08
 */
@MappedSuperclass
public class Entry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Date dateFrom;
	private Date dateTo;
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
	public Date getFrom() {
		return dateFrom;
	}
	public void setFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	/* =================================================================== */
	public Date getTo() {
		return dateTo;
	}
	public void setTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	/* =================================================================== */
	public String getName() {
		return name;
	}
	public void setName(String entry) {
		this.name = entry;
	}
	/* =================================================================== */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
