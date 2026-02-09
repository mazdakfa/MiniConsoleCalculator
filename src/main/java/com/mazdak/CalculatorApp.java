package com.mazdak;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorApp {
    static Scanner input = new Scanner(System.in);
    public static double getDouble(int it){
        while (true) {
            System.out.print("Enter number " + it + " : ");
            try {
                return Double.parseDouble(input.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Non-numeric input. Please enter a number.");
            }
        }
    }

    public static void menu(String menu){
        switch (menu){
            case "main":
                System.out.println("******************[ Main Menu ]*******************");
                System.out.println("*     1. Simple Operations (Two Numbers)         *");
                System.out.println("*     2. Advanced Operations (List of Numbers)   *");
                System.out.println("*     3. Show History                            *");
                System.out.println("*     4. Clear History                           *");
                System.out.println("*     0. Exit                                    *");
                break;
            case "advanced":
                System.out.println("*************[ Advanced Operations ]**************");
                System.out.println("*           1. Sum of the numbers                *");
                System.out.println("*           2. Average of the numbers            *");
                System.out.println("*           3. Maximum of the numbers            *");
                System.out.println("*           4. Minimum of the numbers            *");
                System.out.println("*           5. Enter new numbers                 *");
                System.out.println("*           0. Return to the main menu           *");
                break;
        }
        System.out.println("**************************************************");
    }

    public static char getOperator(){
        while (true){
            System.out.print("Enter the operator (+ - * / %) : ");
            String opStr = input.nextLine();
            try {
                if (opStr.length() != 1){
                    throw new InvalidOperationException("The operator must be a single character.");
                }
                char op = opStr.charAt(0);
                if ("+-*/%".indexOf(op) != -1){
                    return op;
                }else {
                    throw new InvalidOperationException("Invalid operator " + op);
                }
            } catch (InvalidOperationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args){
        CalculatorService calculator = new CalculatorService();
        HistoryService history = new HistoryService();
        boolean inMain = true;
        while (inMain){
            menu("main");
            System.out.print("Enter the number of your desired option : ");
            String selected = input.nextLine();
            try {
                switch (selected){
                    case "1":
                        System.out.println("*******[ Simple Operations (Two Numbers) ]********");
                        double a = getDouble(1);
                        char operator = getOperator();
                        double b = getDouble(2);
                        double result = 0;
                        try {
                            result = calculator.calculate(a,b,operator);
                            String resultStr = String.format("%.1f %s %.1f = %.2f",a,operator,b,result);
                            System.out.println(resultStr);
                            history.add(resultStr);
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                            history.add(String.format("%.1f %s %.1f = %s",a,operator,b,e.getMessage()));
                        }
                        break;
                    case "2":
                        boolean inAdvanced = true;
                        while (inAdvanced) {
                            System.out.println("****[ Advanced Operations (List of Numbers) ]*****");
                            System.out.print("How many numbers do you want to enter? ");
                            int count = Integer.parseInt(input.nextLine());
                            if (count<1){
                                throw new InvalidOperationException("The number of values must be greater than 0.");
                            }
                            ArrayList<Double> nums = new ArrayList<>();
                            for (int i=0;i<count;i++){
                                nums.add(getDouble(i+1));
                            }
                            boolean inOperationMode = true;
                            while (inOperationMode) {
                                menu("advanced");
                                String opStr ="";
                                System.out.print("Enter the number of your desired option : ");
                                selected = input.nextLine();
                                try {
                                    switch (selected){
                                        case "1":
                                            opStr = "Sum";
                                            break;
                                        case "2":
                                            opStr = "Average";
                                            break;
                                        case "3":
                                            opStr = "Maximum";
                                            break;
                                        case "4":
                                            opStr = "Minimum";
                                            break;
                                        case "5":
                                            inOperationMode = false;
                                            break;
                                        case "0":
                                            inOperationMode = false;
                                            inAdvanced = false;
                                            break;
                                        default:
                                            throw new InvalidOperationException("Invalid option. The entered number does not exist in the list.");
                                    }
                                } catch (InvalidOperationException e) {
                                    System.out.println(e.getMessage());
                                    continue;
                                }
                                if (inOperationMode) {
                                    result = calculator.calculate(nums,opStr);
                                    System.out.println(String.format("%s of %s = %.2f",opStr,nums.toString(),result));
                                    history.add(String.format("%s of %s = %.2f",opStr,nums.toString(),result));
                                }
                            }
                        }
                        break;
                    case "3":
                        System.out.println("*******************[ History ]********************");
                        history.show();
                        break;
                    case "4":
                        history.clear();
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
