package com.calculator.calculator.service;

import com.calculator.calculator.model.Calculator;

public class CalculatorService {
    
    public double calculate(Calculator calculator) {
        double result = 0;

        double leftOperand = calculator.getLeft_operant();
        double rightOperand = calculator.getRight_operant();
        String operator = calculator.getOperant();

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

        return result;
    }

}
