package eu.faerierose.cv.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Items on a CV
 * @author FaerieRose
 * @since 2017-06-08
 */
@Table(name="CV__CV")
@Entity
public class CV {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;
	private String summary;
	private String generalRemark;
	@OneToOne(fetch=FetchType.EAGER)
	private PersonalData personalData;
	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Language> languages = new ArrayList<>();
	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Hobby> hobbies = new ArrayList<>();
	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<WorkExperience> workExperiences = new ArrayList<>();
	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<SkillGroup> skillGroups = new ArrayList<>();
	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Certificate> certificates = new ArrayList<>();
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	/* =================================================================== */
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/* =================================================================== */
	public String getGeneralRemark() {
		return generalRemark;
	}
	/* =================================================================== */
	public void setGeneralRemark(String generalRemark) {
		this.generalRemark = generalRemark;
	}
	/* =================================================================== */
	public PersonalData getPersonalData() {
		return personalData;
	}
	public void setPersonalData(PersonalData personalData) {
		this.personalData = personalData;
	}
	/* =================================================================== */
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	public void addLanguage(Language language) {
		this.languages.add(language);
	}
	/* =================================================================== */
	public List<Hobby> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	public void addHobby(Hobby hobby) {
		this.hobbies.add(hobby);
	}
	
	
	
}
