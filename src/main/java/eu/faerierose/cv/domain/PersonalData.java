package eu.faerierose.cv.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import eu.faerierose.domain.Person;

/**
 * The personal data that can usually be found at the header of a CV 
 * @author FaerieRose
 * @since 2017-06-08
 */
@Entity
public class PersonalData extends Person {

	private String birthPlace;
	private String phoneNr;
	private String driversLicense;
	private String linkedIn;
	private String gitHub;
	private String otherLink;
	@OneToOne(fetch=FetchType.EAGER)
	private Address address;


	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	/* =================================================================== */
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	/* =================================================================== */
	public String getPhoneNr() {
		return phoneNr;
	}
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	/* =================================================================== */
	public String getDriversLicense() {
		return driversLicense;
	}
	public void setDriversLicense(String driversLicense) {
		this.driversLicense = driversLicense;
	}
	/* =================================================================== */
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	/* =================================================================== */
	public String getGitHub() {
		return gitHub;
	}
	public void setGitHub(String gitHub) {
		this.gitHub = gitHub;
	}
	/* =================================================================== */
	public String getOtherLink() {
		return otherLink;
	}
	public void setOtherLink(String otherLink) {
		this.otherLink = otherLink;
	}
	
	
	
}
