package com.mazdak;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class CalculatorService {
    public double calculate(double a, double b, char operator){
        BigDecimal aBD = BigDecimal.valueOf(a);
        BigDecimal bBD = BigDecimal.valueOf(b);

        switch (operator){
            case '+':
                BigDecimal sum = aBD.add(bBD);
                return sum.doubleValue();
            case '-':
                BigDecimal sub = aBD.subtract(bBD);
                return sub.doubleValue();
            case '*':
                BigDecimal mul = aBD.multiply(bBD);
                return mul.doubleValue();
            case '/':
                if (b==0){
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                BigDecimal div = aBD.divide(bBD, 4,RoundingMode.HALF_UP);
                return div.doubleValue();
            case '%':
                if (b==0){
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                BigDecimal mod = aBD.remainder(bBD);
                return mod.doubleValue();
            default:
                System.out.println("Invalid Operator.");
        }
        return 0;
    }

    public double calculate(ArrayList<Double> list, String op){
        BigDecimal sumBD = BigDecimal.ZERO;
        BigDecimal numberBD = BigDecimal.ZERO;
        BigDecimal minBD = BigDecimal.valueOf(list.get(0));
        BigDecimal maxBD = BigDecimal.valueOf(list.get(0));
        for (Double number:list){
            numberBD = BigDecimal.valueOf(number);
            sumBD = sumBD.add(numberBD);
            maxBD = (maxBD.compareTo(numberBD)<0)? maxBD :numberBD;
            maxBD = (maxBD.compareTo(numberBD)>0)?maxBD:numberBD;
        }
        switch (op){
            case "Sum":
                return sumBD.doubleValue();
            case "Average":
                return sumBD.divide(BigDecimal.valueOf(list.size()),4,RoundingMode.HALF_UP).doubleValue();
            case "Minimum":
                return minBD.doubleValue();
            case "Maximum":
                return maxBD.doubleValue();
        }
        return 0;
    }

}
