package com.example.dockerbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class DockerbasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerbasicsApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("¡reiniciado!");
	}

}
