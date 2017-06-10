package eu.faerierose.cv.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eu.faerierose.cv.domain.Address;

/**
 * Defines the services that are available for the Address repository
 * @author FaerieRose
 * @since 2017-06-10
 */
@Service
@Transactional
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	/**
	 * Returns the Address for the requested id or null otherwise.
	 * @param id The id of the Address.
	 * @return The Address for the requested id or null otherwise.
	 */
	public Address findById(Long id) {
        Address result = addressRepository.findOne(id);
		return result;
	}

	/**
	 * Creates a new Address in the database if the id of address that has to be created equals 0, otherwise nothing happens.
	 * @param address The Address to be created.
	 * @return The id of the newly created Address, or 0L is nothing was created.
	 */
	public Long create(Address address){
        Long result;
        // Check if address equals null to prevent NullPointerException when calling getId() 
        if (address != null) {
            // Check if the id of the address to be created equals 0. If it is, a new Address is created and the new id will be returned. 
            if (address.getId() == 0) {
                result = addressRepository.save(address).getId();
            } else {
                System.out.println("====== Warning: Not allowed to create new Address that already has an id!");
                result = 0L;
            }
        } else {
            System.out.println("====== Warning: Address trying to create is null!");
            result = 0L;
        }
		return result;
	}

	/**
	 * Updates an existing Address in the database if it exists, otherwise nothing happens.
	 * @param address The Address to be updated.
	 * @return True if the address exists in the database, otherwise false.
	 */
	public boolean update(Address address){
        boolean result;
        // Check if address equals null to prevent NullPointerException when calling getId() 
        if (address != null) {
            // Check if the id of the address to be updated exists. If it does, the Address is updated and return value set to true. 
            if (this.findById(address.getId()) != null) {
            	addressRepository.save(address);
                result = true;
            } else {
                System.out.println("====== Warning: Cannot update Address with id " + address.getId() + "because it does not exist in database!");
                result = false;
            }
        } else {
            System.out.println("====== Warning: Address trying to update is null!");
            result = false;
        }
		return result;
	}

	/**
	 * Deletes a Address from the database with a specific id if it exists.
	 * @param id The id of the Address to be deleted.
	 * @return True if a Address with the requested id existed, otherwise false.
	 */
	public boolean deleteById(Long id) {
        boolean result;
        if (this.findById(id) != null) {
    		addressRepository.delete(id);
            result = true;
        } else {
            System.out.println("====== Warning: Cannot delete Address with id " + id + " because it does not exist in database!");
            result = false;
        }
		return result;
	}
	
	
}


@Component
interface AddressRepository extends CrudRepository<Address, Long> {

}
