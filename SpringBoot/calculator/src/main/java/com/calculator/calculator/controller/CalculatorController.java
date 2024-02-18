package com.calculator.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CalculatorController {
    
    @GetMapping("/calculator")
    public String showCalculatorForm() {
        return "calculator"; 
    }
    
    
                            }
}
