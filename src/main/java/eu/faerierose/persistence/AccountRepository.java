package eu.faerierose.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import eu.faerierose.domain.Account;

@Component
public interface AccountRepository extends CrudRepository<Account, Long> {
	
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	Iterable<Account> findAll();
}
