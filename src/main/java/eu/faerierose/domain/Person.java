package eu.faerierose.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author FaerieRose
 * @since 2017-05-25
 */
@MappedSuperclass
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	private String firstname;
	@Column(nullable=false)
	private String surname;
	private String email;
	private Date birthDate;
	@Lob
	@Column(name = "blob_pictogram", length = 17777215)
	byte[] pictogram;
	
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/* =================================================================== */
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/* =================================================================== */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/* =================================================================== */
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/* =================================================================== */
	public byte[] getPictogram() {
		return pictogram;
	}
	public void setPictogram(byte[] pictogram) {
		this.pictogram = pictogram;
	}

	
	
}
