package com.mazdak;

import java.util.ArrayList;

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

    public double calculate(ArrayList<Double> nums, String op){
        double sum =0;
        double min = nums.get(0);
        double max = nums.get(0);
        for (Double n:nums){
            sum+=n;
            min = (min < n)?min:n;
            max = (max > n)?max:n;
        }
        switch (op){
            case "Sum":
                return sum;
            case "Average":
                return sum / nums.size();
            case "Minimum":
                return min;
            case "Maximum":
                return max;
        }
        return 0;
    }

}
