package org.eclipse.opensmartclide.dbapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class DbApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DbApiApplication.class, args);
	}
}