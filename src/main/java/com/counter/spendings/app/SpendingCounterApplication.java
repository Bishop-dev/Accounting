package com.counter.spendings.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.counter.spendings.repository")
@EntityScan(basePackages = "com.counter.spendings.entity.dal")
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.counter.spendings")
public class SpendingCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendingCounterApplication.class, args);
	}
}
