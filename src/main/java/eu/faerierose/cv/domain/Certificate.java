package eu.faerierose.cv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;


/**
 * 
 * @author FaerieRose
 * @since 2017-06-09
 */
@Table(name="CV__CERTIFICATE")
@Entity
public class Certificate extends Entry {
	private String company;
	@Lob
	@Column(name = "IMAGE", length = 17777215)
	private byte[] image;

	/* =================================================================== */
	/* Getters & Setters                                                   */ 
	/* =================================================================== */
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	/* =================================================================== */
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

	
}
