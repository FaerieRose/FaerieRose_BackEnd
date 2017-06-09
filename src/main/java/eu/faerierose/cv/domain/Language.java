package eu.faerierose.cv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Defines language knowledge for a person, spoken as well as written
 * @author FaerieRose
 * @since 2017-06-08
 */
@Table(name="CV__LANGUAGE")
@Entity
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String language;
	private String levelSpoken;
	private String levelWritten;

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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	/* =================================================================== */
	public String getLevelSpoken() {
		return levelSpoken;
	}
	public void setLevelSpoken(String levelSpoken) {
		this.levelSpoken = levelSpoken;
	}
	/* =================================================================== */
	public String getLevelWritten() {
		return levelWritten;
	}
	public void setLevelWritten(String levelWritten) {
		this.levelWritten = levelWritten;
	}
	
	
}
