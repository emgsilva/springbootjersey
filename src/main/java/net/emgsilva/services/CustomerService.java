package net.emgsilva.services;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import net.emgsilva.dao.models.Customer;
import net.emgsilva.dao.repositories.CustomerRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;

@Profile("web")
@Component
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerService {

	@Inject
	private CustomerRepository customerRepository;

	@Context
	private UriInfo uriInfo;

	@GET
	public Page<Customer> findAll(
			@QueryParam("page") @DefaultValue("0") int page,
			@QueryParam("size") @DefaultValue("20") int size,
			@QueryParam("sort") @DefaultValue("lastname") List<String> sort,
			@QueryParam("direction") @DefaultValue("asc") String direction) {

		return customerRepository.findAll(new PageRequest(page, size,
				Sort.Direction.fromString(direction), sort
						.toArray(new String[0])));
	}

	@GET
	@Path("{id}")
	public Customer findOne(@PathParam("id") Long id) {
		return customerRepository.findOne(id);
	}

	@POST
	@Consumes("application/json")
	public Response save(Customer customer) {
		
		System.out.println("emgsilva-CREATING-CUSTOMER");

		customer = customerRepository.save(customer);

		URI location = uriInfo.getAbsolutePathBuilder().path("{id}")
				.resolveTemplate("id", customer.getId()).build();

		return Response.created(location).build();
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		customerRepository.delete(id);
		return Response.accepted().build();
	}
}