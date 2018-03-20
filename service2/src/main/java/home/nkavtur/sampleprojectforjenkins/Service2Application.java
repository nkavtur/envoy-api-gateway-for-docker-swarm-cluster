package home.nkavtur.sampleprojectforjenkins;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootApplication
@RestController
public class Service2Application {

	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}

	private static final String OK = "Ok";
	private static final String FAIL = "Fail";

	private boolean healthy = true;

	@GetMapping(value = "/who-am-i", produces = APPLICATION_JSON_VALUE)
	@SneakyThrows
	public String whoAmI(HttpServletRequest request) {
		System.out.println(" I SERVICE2 AM HERE!");
		return String.format("%s %s", request.getContextPath(), InetAddress.getLocalHost().toString());
	}

	@GetMapping(value = "/healthcheck", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<String> healthcheck() {
		return healthy ? ResponseEntity.ok(OK) : ResponseEntity.status(503).body(FAIL);
	}

	@PostMapping(value = "/healthcheck", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void healthcheck(@RequestBody Boolean healthy) {
		this.healthy = healthy;
	}

}

