package eu.faerierose.cv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A simple address class containing a street, houseNr, postalCode, city and country 
 * @author FaerieRose
 * @since 2017-06-08
 */
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String street;
	private String houseNr;
	private String postalCode;
	private String city;
	private String country;

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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	/* =================================================================== */
	public String getHouseNr() {
		return houseNr;
	}
	public void setHouseNr(String houseNr) {
		this.houseNr = houseNr;
	}
	/* =================================================================== */
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/* =================================================================== */
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	/* =================================================================== */
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
