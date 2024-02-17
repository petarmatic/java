package com.calculator.calculator.model;

public class Calculator {

        
        private double left_operant;
        private double right_operant;
        private String operant;
        
        

    public Calculator(double left_operant, double right_operant, String operant) {
        this.left_operant = left_operant;
        this.right_operant = right_operant;
        this.operant = operant;
    }

    public Calculator() {
    }

    public double getLeft_operant() {
        return this.left_operant;
    }

    public void setLeft_operant(double left_operant) {
        this.left_operant = left_operant;
    }

    public double getRight_operant() {
        return this.right_operant;
    }

    public void setRight_operant(double right_operant) {
        this.right_operant = right_operant;
    }

    public String getOperant() {
        return this.operant;
    }

    public void setOperant(String operant) {
        this.operant = operant;
    }

    
}
