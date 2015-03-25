package net.emgsilva.web;

import javax.ws.rs.ApplicationPath;

import net.emgsilva.services.CustomerService;
import net.emgsilva.services.HealthService;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(HealthService.class);
		register(CustomerService.class);
	}
}
