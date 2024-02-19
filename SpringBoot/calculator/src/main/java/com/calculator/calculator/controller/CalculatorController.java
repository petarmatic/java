package com.calculator.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CalculatorController {
    
    @GetMapping("/")
    public String index(Model model) {
		model.addAttribute("operator", "+");
		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";
	}

    @PostMapping("/")
    public String calculate(@RequestParam double leftOperand,
                            @RequestParam double rightOperand,
                            @RequestParam String operator) {
        double result = 0;

        
        switch (operator) {
            case "+":
                result = leftOperand + rightOperand;
                break;
            case "-":
                result = leftOperand - rightOperand;
                break;
            case "*":
                result = leftOperand * rightOperand;
                break;
            case "/":
                if (rightOperand != 0) {
                    result = leftOperand / rightOperand;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        // Vratite ime predloška za prikaz rezultata
        return "result";
    }
}
    
                            

