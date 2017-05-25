package eu.faerierose.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import eu.faerierose.domain.Code;

@Component
public interface CodeRepository extends CrudRepository<Code, Long> {

}
