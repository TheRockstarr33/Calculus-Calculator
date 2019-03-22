package com.freeman.algbr;

import com.freeman.calc.Derivative;
import com.freeman.calc.Integral;
import com.freeman.obj.Polynomial;

import java.util.HashMap;
import java.util.Map;

public class Solve {

    //Can find approx by derivative when solving for extrema
    public static double solveForX(Polynomial p, double y) {
//        int max_count = 200;
        int max_count = 800;

//        double tolerance = 0.00000001;
        double tolerance = 0.00000000000001;

        double x = 0;

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
