package com.freeman.algbr;

import com.freeman.calc.Derivative;
import com.freeman.obj.Polynomial;

public class Solve {

    //Can find approx by derivative when solving for extrema
    public static double solveForX(Polynomial p, double y) {
//        int max_count = 200;
        int max_count = 800;

//        double tolerance = 0.00000001;
        double tolerance = 0.00000000000001;

        double x = Math.random();
//        if(Derivative.derivativeOfPolynomial(p).evaluate(0) != 0) {
//            x = 0;
//        } else {
//            x = 1;
//        }

        if(x != 0) {
          for (int i = 1; (Math.abs(y - p.evaluate(x)) > tolerance) && (i < max_count); i++) {
                //Handles situations in which x gets "stuck," when p.evaluate(x) == 0
            x = x - p.evaluate(x) / Derivative.derivativeOfPolynomial(p).evaluate(x);
            }
        }
        if(y-Math.abs(p.evaluate(x)) <= tolerance) {
            return x;
        } else {
            //Uncertain
            System.out.println("UNCERTAIN: ");
            return x;
        }

    }

    public static double solveForX(Polynomial p, double y, double approximation) {
        int max_count = 800;

        double tolerance = 0.00000000000001;

        double x = approximation;

        for(int i = 1; (Math.abs(p.evaluate(x)) > tolerance)&&(i < max_count); i++) {
            x = x - p.evaluate(x)/Derivative.derivativeOfPolynomial(p).evaluate(x);
        }

        if(Math.abs(p.evaluate(x)) <= tolerance) {
            return x;
        } else {
            //Uncertain
            System.out.println("UNCERTAIN: ");
            return x;
        }
    }
}
