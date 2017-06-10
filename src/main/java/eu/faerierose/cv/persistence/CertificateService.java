package eu.faerierose.cv.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eu.faerierose.cv.domain.Certificate;

/**
 * Defines the services that are available for the Certificate repository
 * @author FaerieRose
 * @since 2017-06-10
 */
@Service
@Transactional
public class CertificateService {
	
	@Autowired
	private CertificateRepository certificateRepository;

	/**
	 * Returns the Certificate for the requested id or null otherwise.
	 * @param id The id of the Certificate.
	 * @return The Certificate for the requested id or null otherwise.
	 */
	public Certificate findById(Long id) {
        Certificate result = certificateRepository.findOne(id);
		return result;
	}

	/**
	 * Creates a new Certificate in the database if the id of certificate that has to be created equals 0, otherwise nothing happens.
	 * @param certificate The Certificate to be created.
	 * @return The id of the newly created Certificate, or 0L is nothing was created.
	 */
	public Long create(Certificate certificate){
        Long result;
        // Check if certificate equals null to prevent NullPointerException when calling getId() 
        if (certificate != null) {
            // Check if the id of the certificate to be created equals 0. If it is, a new Certificate is created and the new id will be returned. 
            if (certificate.getId() == 0) {
                result = certificateRepository.save(certificate).getId();
            } else {
                System.out.println("====== Warning: Not allowed to create new Certificate that already has an id!");
                result = 0L;
            }
        } else {
            System.out.println("====== Warning: Certificate trying to create is null!");
            result = 0L;
        }
		return result;
	}

	/**
	 * Updates an existing Certificate in the database if it exists, otherwise nothing happens.
	 * @param certificate The Certificate to be updated.
	 * @return True if the certificate exists in the database, otherwise false.
	 */
	public boolean update(Certificate certificate){
        boolean result;
        // Check if certificate equals null to prevent NullPointerException when calling getId() 
        if (certificate != null) {
            // Check if the id of the certificate to be updated exists. If it does, the Certificate is updated and return value set to true. 
            if (this.findById(certificate.getId()) != null) {
            	certificateRepository.save(certificate);
                result = true;
            } else {
                System.out.println("====== Warning: Cannot update Certificate with id " + certificate.getId() + "because it does not exist in database!");
                result = false;
            }
        } else {
            System.out.println("====== Warning: Certificate trying to update is null!");
            result = false;
        }
		return result;
	}

	/**
	 * Deletes a Certificate from the database with a specific id if it exists.
	 * @param id The id of the Certificate to be deleted.
	 * @return True if a Certificate with the requested id existed, otherwise false.
	 */
	public boolean deleteById(Long id) {
        boolean result;
        if (this.findById(id) != null) {
    		certificateRepository.delete(id);
            result = true;
        } else {
            System.out.println("====== Warning: Cannot delete Certificate with id " + id + " because it does not exist in database!");
            result = false;
        }
		return result;
	}
	
	
}


@Component
interface CertificateRepository extends CrudRepository<Certificate, Long> {

}
