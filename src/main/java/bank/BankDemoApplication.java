package bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableAutoConfiguration
// @ComponentScan("bank")
// @EntityScan("bank.dao")
public class BankDemoApplication {
	public static final String KEY = "KEY";

	public static void main(String[] args) {
		SpringApplication.run(BankDemoApplication.class, args);

	}

}
