package javaman.EncryptData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EncryptDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncryptDataApplication.class, args);
	}

	
}
