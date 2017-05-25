package eu.faerierose.persistence;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.faerierose.domain.Account;

@Path("accounts")
@Component
public class AccountEndpoint {

	@Autowired
	private AccountService accountService;
	
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

}
