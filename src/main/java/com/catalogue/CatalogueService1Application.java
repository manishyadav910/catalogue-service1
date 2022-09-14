package com.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.catalogue")
@EntityScan(basePackages = "com.catalogue.bean")
@EnableJpaRepositories(basePackages = "com.catalogue.persistence")
@EnableEurekaClient
public class CatalogueService1Application {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueService1Application.class, args);
	}

}
