package eu.faerierose.cv.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eu.faerierose.cv.domain.Language;

@Service
@Transactional
public class LanguageService {
	
	@Autowired
	private LanguageRepository languageRepository;

	public Language findById(Long id) {
        Language result = languageRepository.findOne(id);
		return result;
	}

	public Language create(Language language){
        Language result;
        if (language != null) {
            if (language.getId() == 0) {
                result = languageRepository.save(language);
            } else {
                System.out.println("====== Warning: Not allowed to create new Language that already has an id!");
                result = null;
            }
        } else {
            System.out.println("====== Warning: Language trying to create is null!");
            result = null;
        }
		return result;
	}

	public Language update(Language language){
        Language result;
        if (language != null) {
            if (this.findById(language.getId()) != null) {
                result = languageRepository.save(language);
            } else {
                System.out.println("====== Warning: Cannot update Language with id " + language.getId() + "because it does not exist in database!");
                result = null;
            }
        } else {
            System.out.println("====== Warning: Language trying to update is null!");
            result = null;
        }
		return result;
	}


	public boolean deleteById(Long id) {
        boolean result;
        if (this.findById(id) != null) {
    		languageRepository.delete(id);
            result = true;
        } else {
            System.out.println("====== Warning: Cannot delete Language with id " + id + "because it does not exist in database!");
            result = false;
        }
		return result;
	}
	
	
}


@Component
interface LanguageRepository extends CrudRepository<Language, Long> {

}
