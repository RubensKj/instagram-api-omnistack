package br.com.rocketseatbootcamp.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.rocketseatbootcamp.Property.FileStorageProperties;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "br.com.rocketseatbootcamp.controllers", "br.com.rocketseatbootcamp.services" })
@EnableConfigurationProperties({ FileStorageProperties.class })
@EnableJpaRepositories("br.com.rocketseatbootcamp.Repository")
@EntityScan("br.com.rocketseatbootcamp.models")
public class RocketSeatBootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketSeatBootcampApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/posts").allowedOrigins("http://localhost:3000");
				registry.addMapping("/posts/**").allowedOrigins("http://localhost:3000");
			}
		};
	}

}
