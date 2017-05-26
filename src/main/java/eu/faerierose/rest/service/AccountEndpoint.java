package eu.faerierose.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.faerierose.domain.Account;
import eu.faerierose.domain.AccountAnonymous;
import eu.faerierose.domain.AccountUser;
import eu.faerierose.persistence.AccountService;
import eu.faerierose.persistence.SessionService;

@Path("accounts")
@Component
public class AccountEndpoint {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private SessionService sessionService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{username}")
	public Response getAccountByUsername(@PathParam("username") String username) {
		System.out.println("=============== in getAccountByUsername() : Username = " + username);
		if (!username.toLowerCase().equals("anonymous")) {
			AccountUser result = this.accountService.findByUsername(username);
			if (result != null) {
				return Response.ok(result).build();
			}
		}
		return Response.noContent().build();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("auth_req/{username}/{time}")
	public Response requestAuthentication(@PathParam("username") String username, @PathParam("time") String time) {
		if (username.toLowerCase().equals("anonymous")) this.requestAuthenticationAnonymous();
		return Response.ok(this.sessionService.newSessionKey(time, username)).build();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("auth_req")
	public Response requestAuthenticationAnonymous() {
		return Response.ok(this.sessionService.newSessionKey("999999", "anonymous")).build();
	}
	
}
