package eu.faerierose.cv.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eu.faerierose.cv.domain.Skill;

/**
 * Defines the services that are available for the Skill repository
 * @author FaerieRose
 * @since 2017-06-10
 */
@Service
@Transactional
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;

	/**
	 * Returns the Skill for the requested id or null otherwise.
	 * @param id The id of the Skill.
	 * @return The Skill for the requested id or null otherwise.
	 */
	public Skill findById(Long id) {
        Skill result = skillRepository.findOne(id);
		return result;
	}

	/**
	 * Creates a new Skill in the database if the id of skill that has to be created equals 0, otherwise nothing happens.
	 * @param skill The Skill to be created.
	 * @return The id of the newly created Skill, or 0L is nothing was created.
	 */
	public Long create(Skill skill){
        Long result;
        // Check if skill equals null to prevent NullPointerException when calling getId() 
        if (skill != null) {
            // Check if the id of the skill to be created equals 0. If it is, a new Skill is created and the new id will be returned. 
            if (skill.getId() == 0) {
                result = skillRepository.save(skill).getId();
            } else {
                System.out.println("====== Warning: Not allowed to create new Skill that already has an id!");
                result = 0L;
            }
        } else {
            System.out.println("====== Warning: Skill trying to create is null!");
            result = 0L;
        }
		return result;
	}

	/**
	 * Updates an existing Skill in the database if it exists, otherwise nothing happens.
	 * @param skill The Skill to be updated.
	 * @return True if the skill exists in the database, otherwise false.
	 */
	public boolean update(Skill skill){
        boolean result;
        // Check if skill equals null to prevent NullPointerException when calling getId() 
        if (skill != null) {
            // Check if the id of the skill to be updated exists. If it does, the Skill is updated and return value set to true. 
            if (this.findById(skill.getId()) != null) {
            	skillRepository.save(skill);
                result = true;
            } else {
                System.out.println("====== Warning: Cannot update Skill with id " + skill.getId() + "because it does not exist in database!");
                result = false;
            }
        } else {
            System.out.println("====== Warning: Skill trying to update is null!");
            result = false;
        }
		return result;
	}

	/**
	 * Deletes a Skill from the database with a specific id if it exists.
	 * @param id The id of the Skill to be deleted.
	 * @return True if a Skill with the requested id existed, otherwise false.
	 */
	public boolean deleteById(Long id) {
        boolean result;
        if (this.findById(id) != null) {
    		skillRepository.delete(id);
            result = true;
        } else {
            System.out.println("====== Warning: Cannot delete Skill with id " + id + " because it does not exist in database!");
            result = false;
        }
		return result;
	}
	
	
}


@Component
interface SkillRepository extends CrudRepository<Skill, Long> {

}
