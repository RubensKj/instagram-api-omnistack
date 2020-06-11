package br.com.rocketseatbootcamp;

import br.com.rocketseatbootcamp.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class RocketSeatBootcampApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketSeatBootcampApplication.class, args);
    }

}
