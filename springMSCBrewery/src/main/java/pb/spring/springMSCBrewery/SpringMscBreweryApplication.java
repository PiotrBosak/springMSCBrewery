package pb.spring.springMSCBrewery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pb.spring.springMSCBrewery.web.controller.BeerController;

@SpringBootApplication
public class SpringMscBreweryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMscBreweryApplication.class, args);
	}

}
