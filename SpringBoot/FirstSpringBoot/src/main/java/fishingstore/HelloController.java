/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fishingstore;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author petar
 */
@SpringBootApplication

public class HelloController {
    
    
    public String index() {
		return "Greetings from Spring Boot!";
	}
    
}
