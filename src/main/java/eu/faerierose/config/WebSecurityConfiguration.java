package eu.faerierose.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
@EnableGlobalMethodSecurity(securedEnabled = true)
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
        Account account = accountService.findAccount(username);
        if(account instanceof AccountUser) {
        	AccountUser acc = (AccountUser)account;
        	return new User(acc.getUsername(), acc.clarifyPassword(), true, true, true, true,
        			AuthorityUtils.createAuthorityList(acc.getRolesAsStringArray()));
        } else if (account instanceof AccountAnonymous) {
        	AccountAnonymous acc = (AccountAnonymous)account;
        	return new User(acc.getUsername(), acc.clarifyPassword(), true, true, true, true,
        			AuthorityUtils.createAuthorityList(acc.getRolesAsStringArray()));
        } else {
          throw new UsernameNotFoundException("could not find the user '" + username + "'");
        }
      }
    };
  }
  
  
}