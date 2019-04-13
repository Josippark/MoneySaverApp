package hr.java.web.pavlovic.moneyapp;

import hr.java.web.pavlovic.moneyapp.model.User;
import hr.java.web.pavlovic.moneyapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MoneyappApplication  {

	public static void main(String[] args) {
		SpringApplication.run(MoneyappApplication.class, args);
	}



}
