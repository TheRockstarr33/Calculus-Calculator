package com.freeman.algbr;

import com.freeman.calc.Derivative;
import com.freeman.calc.Integral;
import com.freeman.obj.Polynomial;

import java.util.HashMap;
import java.util.Map;

public class Solve {

    public static void main(String[] args) {
        Map m2 = new HashMap();
        m2.put(15.0, 2.0);
        m2.put(28.0, 1.0);
        m2.put(7.0, 0.0);
        Polynomial p = new Polynomial(m2);

        System.out.println(solveForX(p, 0.0, 0.0));
    }

    public static double solveForX(Polynomial p, double y) {
//        Integral.
        return 0.0;
    }

    //Can find approx by derivative when solving for extrema
    public static double solveForX(Polynomial p, double y, double approximation) {
        int max_count = 200;

        double tolerance = 0.00000001;

        double x = 0;

        for(int i = 1; (Math.abs(p.evaluate(x)) > tolerance)&&(i < max_count); i++) {
            x = x - p.evaluate(x)/Derivative.derivativeOfPolynomial(p).evaluate(x);
        }

        if(Math.abs(p.evaluate(x)) <= tolerance) {
            return x;
        } else {
            //Uncertain
            return x;
        }
    }
}
