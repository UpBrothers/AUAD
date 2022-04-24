package yu.upbro.auad.api.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AuadApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuadApplication.class, args);
	}
}