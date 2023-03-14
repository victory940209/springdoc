package com.victory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class TestSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TestSpringbootApplication.class);
	    app.addListeners(new ApplicationPidFileWriter()); // 
	    app.run(args);   
	}
}
