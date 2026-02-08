package com.mazdak;

public class CalculatorService {
    public double calculate(double a, double b, char operator){
        switch (operator){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                if (b==0){
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return a/b;
            case '%':
                if (b==0){
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return a%b;
            default:
                System.out.println("Invalid Operator.");
        }
        return 0;
    }
}
