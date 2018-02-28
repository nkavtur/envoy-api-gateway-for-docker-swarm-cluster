package home.nkavtur.sampleprojectforjenkins;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootApplication
@RestController
public class SampleProjectForJenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleProjectForJenkinsApplication.class, args);
	}


	@GetMapping(value = "/who-am-i", produces = APPLICATION_JSON_VALUE)
	@SneakyThrows
	public String whoAmI() {
		return InetAddress.getLocalHost().toString();
	}
}
