package net.emgsilva.services;

import static org.assertj.core.api.Assertions.assertThat;
import net.emgsilva.Application;
import net.emgsilva.dao.models.Health;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
@ActiveProfiles("web")
public class HealthControllerTest {

    private RestTemplate restTemplate = new TestRestTemplate("demo", "123");

    @Test
    public void jerseyHealth() {
        ResponseEntity<Health> entity =
                restTemplate.getForEntity("http://localhost:9000/health", Health.class);

        assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(entity.getBody().getStatus()).isEqualTo("Jersey: Up and Running!");
    }

    @Test
    public void springHealth() {
        ResponseEntity<Health> entity =
                restTemplate.getForEntity("http://localhost:9000/s/spring-health", Health.class);

        assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(entity.getBody().getStatus()).isEqualTo("Spring MVC: Up and Running!");
    }
}