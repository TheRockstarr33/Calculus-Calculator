package com.freeman.ui.terminal;

import java.util.Scanner;

public class MainMenu {

    public static void main(String args[]) {
        System.out.println("Welcome to the Calculus Calculator!");
        int testMain = 0;
        while(testMain != 2) {
            testMain = mainMenu();
        }
    }

    public static int mainMenu() {
        System.out.println("1. Calculus");
        System.out.println("2. Algebra");
//        System.out.println("3. ");
//        System.out.println("4. ");

        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();

        if(a.equals("1")) {
            CalcMenu.calcMenu(scanner);
        } else if(a.equals("2")) {
            System.out.println("Not done yet.");
        } else {
            System.out.println("Please enter valid input. (1, 2)");
        }
        return 0;
    }
}
