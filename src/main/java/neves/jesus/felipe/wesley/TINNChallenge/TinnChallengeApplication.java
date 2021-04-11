package neves.jesus.felipe.wesley.TINNChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TinnChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinnChallengeApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/veiculos").allowedOrigins("http://localhost:4200","https://localhost:4200").allowedMethods("*");
				registry.addMapping("/veiculos/*").allowedOrigins("http://localhost:4200","https://localhost:4200").allowedMethods("*");
			}
		};
	}

}
