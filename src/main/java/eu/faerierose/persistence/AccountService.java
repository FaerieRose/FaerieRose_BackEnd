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
		System.out.println("\n=============== in findfindByUsername()");
		Iterable<Account> accounts = this.accountRepository.findAll();
//		List<Account> accounts = (ArrayList<Account>) this.accountRepository.findAll();
//		System.out.println("=============== in findfindByUsername() : " + accounts.size() );
		for (Account account: accounts) {
			if (account instanceof AccountUser) System.out.println("=============== in findfindByUsername() : username = " + ((AccountUser) account).getUsername());
			System.out.println("=============== in findfindByUsername() : username = " + account.getUsername());
			if (account.getUsername() != null && account.getUsername().equals(username)) {
				return (AccountUser) account;
			}
		}
		System.out.println("=============== in findfindByUsername() : return null");
		return null;
	}
	
	public void save(Account account) {
		this.accountRepository.save(account);
	}
}
