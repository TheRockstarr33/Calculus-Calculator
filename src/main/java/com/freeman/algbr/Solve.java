package com.freeman.algbr;

import com.freeman.calc.Derivative;
import com.freeman.obj.Polynomial;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**
     * Solves a quadratic equation, only works when 0.0, 1.0, and
     * 2.0 are defined in the Polynomial map.
     *
     * @param p
     * @return
     */
    public static List<Double> solveForQuadratic(Polynomial p) {
        Map<Double, Double> m = p.getTerms();
        if(m.get(2.0)!=null) {
            return solveForXQuadratic(m.get(2.0), m.get(1.0), m.get(0.0));
        } else {
            return solveForXLinear(m.get(1.0), m.get(0.0));
        }
    }

    public static List<Double> solveForXQuadratic(double a, double b, double c) {
        List<Double> resultList = new ArrayList<Double>();
        double temp1 = Math.sqrt(b * b - 4 * a * c);
        double root1 = (-b + temp1) / (2 * a);
        double root2 = (-b - temp1) / (2 * a);
        resultList.add(root1);
        resultList.add(root2);
        return resultList;
    }

    public static List<Double>  solveForXLinear(double b, double c) {
        List<Double> resultList = new ArrayList<Double>();
        resultList.add(-c / b);
        return resultList;
    }
}
