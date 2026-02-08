package com.mazdak;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean inMain = true;
        while (inMain){
            System.out.println("******************[ Main Menu ]*******************");
            System.out.println("*     1. Simple Operations (Two Numbers)         *");
            System.out.println("*     2. Advanced Operations (List of Numbers)   *");
            System.out.println("*     3. Show History                            *");
            System.out.println("*     4. Clear History                           *");
            System.out.println("*     0. Exit                                    *");
            System.out.println("**************************************************");
            String selected = input.nextLine();
            switch (selected){
                case "1":
                    System.out.println("*******[ Simple Operations (Two Numbers) ]********");
                    break;
                case "2":
                    System.out.println("****[ Advanced Operations (List of Numbers) ]*****");
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
                    System.out.println("****************[ Invalid Option ]****************");
            }
        }
    }
}
