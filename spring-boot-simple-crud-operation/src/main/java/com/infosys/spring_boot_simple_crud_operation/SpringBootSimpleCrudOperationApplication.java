package com.infosys.spring_boot_simple_crud_operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class SpringBootSimpleCrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimpleCrudOperationApplication.class, args);
		
	}
	@Bean
	public OpenAPI openApi() {
		return new OpenAPI()
				.info(new Info()
						.title("Employee-Management-System")
						.description("This project will be only perform CRUD operation")
						.version("1.0")
						);
	}

}
