package com.mazdak;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        CalculatorService calculator = new CalculatorService();
        boolean inMain = true;
        while (inMain){
            System.out.println("******************[ Main Menu ]*******************");
            System.out.println("*     1. Simple Operations (Two Numbers)         *");
            System.out.println("*     2. Advanced Operations (List of Numbers)   *");
            System.out.println("*     3. Show History                            *");
            System.out.println("*     4. Clear History                           *");
            System.out.println("*     0. Exit                                    *");
            System.out.println("**************************************************");
            System.out.print("Enter the number of your desired option : ");
            String selected = input.nextLine();
            try {
                switch (selected){
                    case "1":
                        System.out.println("*******[ Simple Operations (Two Numbers) ]********");
                        System.out.print("Enter first number: ");
                        double a = Double.parseDouble(input.nextLine());
                        System.out.print("Enter operator (+ - * / %) : ");
                        String opStr = input.nextLine();
                        if (opStr.length() != 1){
                            throw new InvalidOperationException("The operator must be a single character.");
                        }
                        char operator = opStr.charAt(0);
                        if ("+-*/%".indexOf(operator) == -1){
                            throw new InvalidOperationException("Invalid operator " + operator);
                        }
                        System.out.print("Enter second number: ");
                        double b = Double.parseDouble(input.nextLine());
                        double result = calculator.calculate(a,b,operator);
                        System.out.println(String.format("%.1f %s %.1f = %.2f",a,operator,b,result));
                        break;
                    case "2":
                        System.out.println("****[ Advanced Operations (List of Numbers) ]*****");
                        System.out.print("How many numbers do you want to enter? ");
                        int count = Integer.parseInt(input.nextLine());
                        if (count<1){
                            throw new InvalidOperationException("The number of values must be greater than 0.");
                        }

                        break;
                    case "3":
                        System.out.println("*******************[ History ]********************");
                        break;
                    case "4":
                        System.out.println("*********[ History completely cleared. ]**********");
                        break;
                    case "0":
                        System.out.println("********************[ FINISH ]********************");
                        inMain = false;
                        break;
                    default:
                        throw new InvalidOperationException("Invalid option. The entered number does not exist in the list.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Non-numeric input. Please enter a number.");
            } catch (InvalidOperationException|ArithmeticException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
