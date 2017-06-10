package eu.faerierose.cv.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eu.faerierose.cv.domain.Language;

/**
 * Defines the services that are available for the Language repository
 * @author FaerieRose
 * @since 2017-06-10
 */
@Service
@Transactional
public class LanguageService {
	
	@Autowired
	private LanguageRepository languageRepository;

	/**
	 * Returns the Language for the requested id or null otherwise.
	 * @param id The id of the Language.
	 * @return The Language for the requested id or null otherwise.
	 */
	public Language findById(Long id) {
        Language result = languageRepository.findOne(id);
		return result;
	}

	/**
	 * Creates a new Language in the database if the id of language that has to be created equals 0, otherwise nothing happens.
	 * @param language The Language to be created.
	 * @return The id of the newly created Language, or 0L is nothing was created.
	 */
	public Long create(Language language){
        Long result;
        // Check if language equals null to prevent NullPointerException when calling getId() 
        if (language != null) {
            // Check if the id of the language to be created equals 0. If it is, a new Language is created and the new id will be returned. 
            if (language.getId() == 0) {
                result = languageRepository.save(language).getId();
            } else {
                System.out.println("====== Warning: Not allowed to create new Language that already has an id!");
                result = 0L;
            }
        } else {
            System.out.println("====== Warning: Language trying to create is null!");
            result = 0L;
        }
		return result;
	}

	/**
	 * Updates an existing Language in the database if it exists, otherwise nothing happens.
	 * @param language The Language to be updated.
	 * @return True if the language exists in the database, otherwise false.
	 */
	public boolean update(Language language){
        boolean result;
        // Check if language equals null to prevent NullPointerException when calling getId() 
        if (language != null) {
            // Check if the id of the language to be updated exists. If it does, the Language is updated and return value set to true. 
            if (this.findById(language.getId()) != null) {
            	languageRepository.save(language);
                result = true;
            } else {
                System.out.println("====== Warning: Cannot update Language with id " + language.getId() + "because it does not exist in database!");
                result = false;
            }
        } else {
            System.out.println("====== Warning: Language trying to update is null!");
            result = false;
        }
		return result;
	}

	/**
	 * Deletes a Language from the database with a specific id if it exists.
	 * @param id The id of the Language to be deleted.
	 * @return True if a Language with the requested id existed, otherwise false.
	 */
	public boolean deleteById(Long id) {
        boolean result;
        if (this.findById(id) != null) {
    		languageRepository.delete(id);
            result = true;
        } else {
            System.out.println("====== Warning: Cannot delete Language with id " + id + " because it does not exist in database!");
            result = false;
        }
		return result;
	}
	
	
}


@Component
interface LanguageRepository extends CrudRepository<Language, Long> {

}
