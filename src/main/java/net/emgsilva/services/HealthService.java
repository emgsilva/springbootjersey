package net.emgsilva.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import net.emgsilva.dao.models.Health;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
// Spring MVC annotation
@RestController
@Path("/health")
public class HealthService {

	@GET
	@Produces({ "application/json" })
	public Health jersey() {
		return new Health("Jersey: Up and Running!");
	}

	@RequestMapping(value = "/spring-health", produces = "application/json")
	// Spring MVC
	public Health springMvc() {
		return new Health("Spring MVC: Up and Running!");
	}

}
