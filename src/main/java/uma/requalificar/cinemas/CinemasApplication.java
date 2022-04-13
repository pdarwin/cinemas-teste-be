package uma.requalificar.cinemas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CinemasApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(CinemasApplication.class, args);
	}

}
