package com.application.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SocietyManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(SocietyManagementApplication.class, args);
	}

}