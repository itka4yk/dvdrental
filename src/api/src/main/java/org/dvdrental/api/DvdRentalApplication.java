package org.dvdrental.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages  = "org.dvdrental")
@EnableJpaRepositories(basePackages={"org.dvdrental"})
@EnableAutoConfiguration
public class DvdRentalApplication {
    public static void main(String[] args) {
        SpringApplication.run(DvdRentalApplication.class, args);
    }
}
