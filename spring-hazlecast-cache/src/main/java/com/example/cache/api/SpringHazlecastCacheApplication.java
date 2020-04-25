package com.example.cache.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringHazlecastCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHazlecastCacheApplication.class, args);
	}

}
