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
	@Path("{id}")
	public Response getUserById(@PathParam("id") Long id) {
		
		Account result = this.accountService.findById(id);
		return Response.ok(result).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserAll() {
		Iterable<Account> result = this.accountService.findAll();
		return Response.ok(result).build();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("auth_req/{username}/{time}")
	public Response requestAuthentication(@PathParam("username") String username, @PathParam("time") String time) {
		return Response.ok(this.sessionService.newSessionKey(time, username)).build();
	}
	
}
