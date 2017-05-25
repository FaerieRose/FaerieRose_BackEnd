package eu.faerierose.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import eu.faerierose.domain.Session;

@Component
public interface SessionRepository extends CrudRepository<Session, Long> {

}
