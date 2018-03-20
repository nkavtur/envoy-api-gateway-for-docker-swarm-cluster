package home.nkavtur.sampleprojectforjenkins;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.function.Predicate;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootApplication
@RestController
public class Service1Application {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

	private static final String OK = "Ok";
	private static final String FAIL = "Fail";

	private boolean healthy = true;

	private RestTemplate restTemplate = new RestTemplate();

	@GetMapping(value = "/call-service2", produces = APPLICATION_JSON_VALUE)
	@SneakyThrows
	public String callService2() {
		return restTemplate.getForObject("http://service2:9090/service2/who-am-i", String.class);
	}

	@GetMapping(value = "/who-am-i", produces = APPLICATION_JSON_VALUE)
	@SneakyThrows
	public String whoAmI(HttpServletRequest request) {
		return String.format("%s %s", request.getContextPath(), InetAddress.getLocalHost().toString());
	}

	@GetMapping(value = "/healthcheck", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> healthcheck() {
		System.out.println("HEALTH CHECK CALL!!!!!!!!!!!!!!!!!");
		return healthy ? ResponseEntity.ok(OK) : ResponseEntity.status(503).body(FAIL);
	}

	@PostMapping(value = "/healthcheck", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void healthcheck(@RequestBody Boolean healthy) {
		this.healthy = healthy;
	}

}
