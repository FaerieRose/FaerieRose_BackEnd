package eu.faerierose.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.faerierose.domain.Account;

@Service
@Transactional
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	public Account findById(Long id) {
		return this.accountRepository.findOne(id);
	}
	
	public Iterable<Account> findAll() {
		return this.accountRepository.findAll();
	}
	
	public Account findByUsername(String username) {
		Iterable<Account> accounts = findAll();
		for (Account account: accounts) {
			System.out.println(account.getUsername());
			if (account.getUsername().equals(username)) {
				return account;
			}
		}
		return null;
	}	
}
