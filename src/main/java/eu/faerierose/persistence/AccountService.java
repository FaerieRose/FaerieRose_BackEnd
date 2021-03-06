package eu.faerierose.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.faerierose.domain.Account;
import eu.faerierose.domain.AccountAnonymous;
import eu.faerierose.domain.AccountUser;

@Service
@Transactional
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
//	public Account findById(Long id) {
//		return this.accountRepository.findOne(id);
//	}
	
//	public Iterable<Account> findAll() {
//		System.out.println("\n=============== in findAll()");
//		Iterable<Account> accounts = this.accountRepository.findAll();
//		for (Account account: accounts) {
//			if (account instanceof AccountUser) {
//				System.out.println("=============== in findAll() : User : username = " + account.getUsername());
//			} else {
//				System.out.println("=============== in findAll() : Anonymous");
//			}
//		}
//		return accounts;
//	}
	
	public AccountUser findByUsername(String username) {
		Iterable<Account> accounts = this.accountRepository.findAll();
		for (Account account: accounts) {
			if (account instanceof AccountUser) {
				AccountUser result = (AccountUser) account; 
				if (result.getUsername().equals(username)) {
					System.out.println("=============== in findByUsername() : username = " + result.getUsername());
					return result;
				}
			}
		}
		return null;
	}
	
	
	public Account findAccount(String username) {
		Account result = this.findByUsername(username);
		if (result == null) {
			Iterable<Account> accounts = this.accountRepository.findAll();
			for (Account account: accounts) {
				if (account instanceof AccountAnonymous) {
					result = account;
				}
			}
		}
		if (result == null) {
			result = new AccountAnonymous();
			result.setUsername("anonymous");
			result.setFirstname("-");
			result.setSurname("-");
			result.addRole("ROLE_ANONYMOUS");
			this.save(result);
		}
		return result;
	}
	
	public void save(Account account) {
		this.accountRepository.save(account);
	}
}
