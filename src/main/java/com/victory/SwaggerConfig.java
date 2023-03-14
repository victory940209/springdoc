package com.victory;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "TEST API",
				description = "API Document",
				version = "v0.1",
				contact = @Contact(
						name = "victory",
						email = "victory940209@gmail.com"
				)
		)
)

@Configuration
public class SwaggerConfig {

	@Bean
	GroupedOpenApi group1() {
		return GroupedOpenApi
				.builder()
				.group("path1")
				.pathsToMatch("/path1/**")
				.build();
	}

	@Bean
	GroupedOpenApi group2() {
		return GroupedOpenApi
				.builder()
				.group("path2")
				.pathsToMatch("/path2/**")
				.build();
	}
}
