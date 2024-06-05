package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Jackets;
import com.example.demo.entity.Pants;
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
			Jackets[] jackets = new Jackets[] {
            new Jackets("Jacket 1", 49.99),
            new Jackets("Jacket 2", 59.99),
            new Jackets("Jacket 3", 69.99),
            new Jackets("Jacket 4", 79.99),
            new Jackets("Jacket 5", 89.99),
            new Jackets("Jacket 6", 99.99),
            new Jackets("Jacket 7", 109.99),
            new Jackets("Jacket 8", 119.99),
            new Jackets("Jacket 9", 129.99),
            new Jackets("Jacket 10", 139.99)
        };

        for (Jackets jacket : jackets) {
            jacketsRepository.save(jacket);
        }
	
}
}


	

	
	


