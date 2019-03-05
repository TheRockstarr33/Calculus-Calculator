package com.freeman.ui.terminal;

import com.freeman.calc.Derivative;
import com.freeman.calc.Integral;
import com.freeman.obj.Polynomial;

import java.util.Scanner;

public class CalcMenu {

    public static void derivativeMenu(Scanner scanner) {
        System.out.println("Please enter your function: ");
        String sFunc = scanner.nextLine();
        Polynomial p = new Polynomial(sFunc);
        Polynomial f = Derivative.derivativeOfPolynomial(p);

        System.out.println(f);
    }

    public static void integralMenu(Scanner scanner) {
        System.out.println("1. Indefinite Integral");
        System.out.println("2. Definite Integral");
        System.out.println("3. Simpson's Approximation");
        System.out.println("4. Trapezoidal Approximation");

        String a = scanner.nextLine();

        if(a.equals("1")) {
            System.out.println("Please enter your function: ");
            String sFunc = scanner.nextLine();
            Polynomial p = new Polynomial(sFunc);
            Polynomial f = Integral.indefIntegralOfPolynomial(p);
            System.out.println(f);
        } else if(a.equals("2")) {
            System.out.println("Please enter your function: ");
            String sFunc = scanner.nextLine();
            System.out.println("Please enter the low end of the domain: ");
            double d1 = Double.valueOf(scanner.nextLine());
            System.out.println("Please enter the high end of the domain: ");
            double d2 = Double.parseDouble(scanner.nextLine());

            Polynomial p = new Polynomial(sFunc);
            double f = Integral.defIntegralOfPolynomial(p, new double[]{d1, d2});

            System.out.println(f);
        } else if(a.equals("3")) {
            System.out.println("Please enter your function: ");
            String sFunc = scanner.nextLine();
            System.out.println("Please enter the low end of the domain: ");
            double d1 = Double.valueOf(scanner.nextLine());
            System.out.println("Please enter the high end of the domain: ");
            double d2 = Double.parseDouble(scanner.nextLine());
            System.out.println("Please enter the number of iterations: ");
            int i1 = Integer.parseInt(scanner.nextLine());

            Polynomial p = new Polynomial(sFunc);
            double f = Integral.simpsonsApproximation(p, new double[]{d1, d2}, i1);

            System.out.println(f);
        } else if(a.equals("4")) {
            System.out.println("Please enter your function: ");
            String sFunc = scanner.nextLine();
            System.out.println("Please enter the low end of the domain: ");
            double d1 = Double.valueOf(scanner.nextLine());
            System.out.println("Please enter the high end of the domain: ");
            double d2 = Double.parseDouble(scanner.nextLine());
            System.out.println("Please enter the number of iterations: ");
            int i1 = Integer.parseInt(scanner.nextLine());

            Polynomial p = new Polynomial(sFunc);
            double f = Integral.trapezoidalApproximation(p, new double[]{d1, d2}, i1);

            System.out.println(f);
        }
    }

    public static int calcMenu(Scanner scanner) {
        System.out.println("1. Derivative");
        System.out.println("2. Integral");

        String a = scanner.nextLine();

        if(a.equals("1")) {
            derivativeMenu(scanner);
        } else if(a.equals("2")) {
            integralMenu(scanner);
        } else {
            System.out.println("Please enter valid input. (1, 2)");
        }
        return 0;
    }
}
