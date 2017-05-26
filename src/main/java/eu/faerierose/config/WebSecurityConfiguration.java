package eu.faerierose.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import eu.faerierose.domain.Account;
import eu.faerierose.domain.AccountAnonymous;
import eu.faerierose.domain.AccountUser;
import eu.faerierose.persistence.AccountService;

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

  @Autowired
  AccountService accountService;

  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService());
    
  }

  @Bean
  UserDetailsService userDetailsService() {
    return new UserDetailsService() {
      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("\n\n=============== in userDetailsService()");
        Account account = accountService.findByUsername(username);
        System.out.println("=============== in userDetailsService() : username = " + account.acquireUsername());
        if(account instanceof AccountUser) {
        	AccountUser acc = (AccountUser)account;
            System.out.println("=============== in userDetailsService() : username = " + acc.acquireUsername());
        	return new User(acc.acquireUsername(), acc.clarifyPassword(), true, true, true, true,
        			AuthorityUtils.createAuthorityList(acc.getRolesAsStringArray()));
        } else if (account instanceof AccountAnonymous) {
        	AccountAnonymous acc = (AccountAnonymous)account;
            System.out.println("=============== in userDetailsService() : username = " + acc.acquireUsername());
        	return new User(acc.acquireUsername(), acc.clarifyPassword(), true, true, true, true,
        			AuthorityUtils.createAuthorityList(acc.getRolesAsStringArray()));
        }
        {
          throw new UsernameNotFoundException("could not find the user '" + username + "'");
        }
      }
    };
  }
}