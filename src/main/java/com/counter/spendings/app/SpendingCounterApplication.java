package com.counter.spendings.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.counter.spendings")
public class SpendingCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendingCounterApplication.class, args);
	}
}
