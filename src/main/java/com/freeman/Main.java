package com.freeman;

import com.freeman.calc.Integral;
import com.freeman.obj.Polynomial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Calculus Calculator!");

        System.out.println("Please enter your function: ");
        Scanner input = new Scanner(System.in);
        String sFunc = input.nextLine();
        //TODO: Add parsing from String to function, maybe create a function class?

//        Function func = new Function(sFunc);
        Polynomial p = new Polynomial(sFunc);
//        p.printPolynomialParts();

        Polynomial f = Integral.indefIntegralOfPolynomial(p);

        System.out.println("");
        System.out.println("");
        System.out.println("");
//        System.out.println(p.getPolynomialText());
//        System.out.println(f.getPolynomialText());

        //5x^2+3x-7

        System.out.println("");
        System.out.println("");
        System.out.println("");
//        System.out.println(Integral.trapezoidalApproximation(p, new double[]{1.0, 4.0}, 1));
//        System.out.println(Integral.trapezoidalApproximation(p, new double[]{1.0, 4.0}, 4));//4-x^2
//        System.out.println(Integral.trapezoidalApproximation(p, new double[]{1.0, 4.0}, 50));
        System.out.println(Integral.trapezoidalApproximation(p, new double[]{1.0, 4.0}, 6));
        System.out.println(Integral.trapezoidalApproximation(p, new double[]{1.0, 4.0}, 100));
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(Integral.simpsonsApproximation(p, new double[]{1.0, 4.0}, 6));
        System.out.println(Integral.simpsonsApproximation(p, new double[]{1.0, 4.0}, 100));
    }
}
