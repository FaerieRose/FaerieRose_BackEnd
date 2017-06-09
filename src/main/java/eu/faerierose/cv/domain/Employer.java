package eu.faerierose.cv.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Basic characteristics of an employer that can found on a CV
 * @author FaerieRose
 * @since 2017-06-08
 */
@Table(name="CV__EMPLOYER")
@Entity
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String url;
	@OneToOne(fetch=FetchType.EAGER)
	private Address address;

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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	/* =================================================================== */
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
