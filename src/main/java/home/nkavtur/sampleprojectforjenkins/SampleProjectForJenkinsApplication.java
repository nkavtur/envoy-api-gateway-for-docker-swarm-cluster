package home.nkavtur.sampleprojectforjenkins;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@SpringBootApplication
@RestController
public class SampleProjectForJenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleProjectForJenkinsApplication.class, args);
	}


	@GetMapping("/who-am-i")
	@SneakyThrows
	public String whoAmI() {
		return InetAddress.getLocalHost().toString();
	}
}
