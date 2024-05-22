package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.JacketsRepository;
import com.example.demo.repository.PantsRepository;
import com.example.demo.repository.ShirtsRepository;





@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {


	@Autowired
	JacketsRepository jacketsRepository;

	@Autowired
	PantsRepository pantsRepository;

	@Autowired
	ShirtsRepository shirtsRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
