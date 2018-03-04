package home.nkavtur.sampleprojectforjenkins;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootApplication
@RestController
public class Service1Application {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}


	@GetMapping(value = "/who-am-i", produces = APPLICATION_JSON_VALUE)
	@SneakyThrows
	public String whoAmI(HttpServletRequest request) {
		return String.format("%s %s", request.getContextPath(), InetAddress.getLocalHost().toString());
	}
}
