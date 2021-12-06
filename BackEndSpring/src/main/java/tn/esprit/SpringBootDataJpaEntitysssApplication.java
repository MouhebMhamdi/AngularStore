package tn.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan(basePackages = {"tn.esprit.model"})
@Configuration
@EnableJpaRepositories("tn.esprit.Repositories")
@EnableSwagger2
public class SpringBootDataJpaEntitysssApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaEntitysssApplication.class, args);
	}

}
