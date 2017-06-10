package eu.faerierose.cv.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eu.faerierose.cv.domain.Hobby;

/**
 * Defines the services that are available for the Hobby repository
 * @author FaerieRose
 * @since 2017-06-10
 */
@Service
@Transactional
public class HobbyService {
	
	@Autowired
	private HobbyRepository hobbyRepository;

	/**
	 * Returns the Hobby for the requested id or null otherwise.
	 * @param id The id of the Hobby.
	 * @return The Hobby for the requested id or null otherwise.
	 */
	public Hobby findById(Long id) {
        Hobby result = hobbyRepository.findOne(id);
		return result;
	}

	/**
	 * Creates a new Hobby in the database if the id of hobby that has to be created equals 0, otherwise nothing happens.
	 * @param hobby The Hobby to be created.
	 * @return The id of the newly created Hobby, or 0L is nothing was created.
	 */
	public Long create(Hobby hobby){
        Long result;
        // Check if hobby equals null to prevent NullPointerException when calling getId() 
        if (hobby != null) {
            // Check if the id of the hobby to be created equals 0. If it is, a new Hobby is created and the new id will be returned. 
            if (hobby.getId() == 0) {
                result = hobbyRepository.save(hobby).getId();
            } else {
                System.out.println("====== Warning: Not allowed to create new Hobby that already has an id!");
                result = 0L;
            }
        } else {
            System.out.println("====== Warning: Hobby trying to create is null!");
            result = 0L;
        }
		return result;
	}

	/**
	 * Updates an existing Hobby in the database if it exists, otherwise nothing happens.
	 * @param hobby The Hobby to be updated.
	 * @return True if the hobby exists in the database, otherwise false.
	 */
	public boolean update(Hobby hobby){
        boolean result;
        // Check if hobby equals null to prevent NullPointerException when calling getId() 
        if (hobby != null) {
            // Check if the id of the hobby to be updated exists. If it does, the Hobby is updated and return value set to true. 
            if (this.findById(hobby.getId()) != null) {
            	hobbyRepository.save(hobby);
                result = true;
            } else {
                System.out.println("====== Warning: Cannot update Hobby with id " + hobby.getId() + "because it does not exist in database!");
                result = false;
            }
        } else {
            System.out.println("====== Warning: Hobby trying to update is null!");
            result = false;
        }
		return result;
	}

	/**
	 * Deletes a Hobby from the database with a specific id if it exists.
	 * @param id The id of the Hobby to be deleted.
	 * @return True if a Hobby with the requested id existed, otherwise false.
	 */
	public boolean deleteById(Long id) {
        boolean result;
        if (this.findById(id) != null) {
    		hobbyRepository.delete(id);
            result = true;
        } else {
            System.out.println("====== Warning: Cannot delete Hobby with id " + id + " because it does not exist in database!");
            result = false;
        }
		return result;
	}
	
	
}


@Component
interface HobbyRepository extends CrudRepository<Hobby, Long> {

}
