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
	private String entry;

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
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	
	
}
