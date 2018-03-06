package home.nkavtur.sampleprojectforjenkins;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootApplication
@RestController
public class Service1Application {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

	private RestTemplate restTemplate;

	@GetMapping(value = "/call-service2", produces = APPLICATION_JSON_VALUE)
	@SneakyThrows
	public String callService2() {
		restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://service2:9090/service2/who-am-i", String.class);
	}


	@GetMapping(value = "/who-am-i", produces = APPLICATION_JSON_VALUE)
	@SneakyThrows
	public String whoAmI(HttpServletRequest request) {
		System.out.println(" I SERVICE1 AM HERE!");
		return String.format("%s %s", request.getContextPath(), InetAddress.getLocalHost().toString());
	}
}
