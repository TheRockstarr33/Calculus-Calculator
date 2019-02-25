package com.freeman.calc;

import com.freeman.obj.Polynomial;

import java.util.HashMap;
import java.util.Map;

public abstract class Integral {

    //INTERVAL SHOULD BE LOW TO HIGH
    public static double trapezoidalApproximation(Polynomial p, double[] interval, int n) {
        Map<Double, Double> pTerms = p.getTerms();
        double dist = (interval[1] - interval[0])/n;    //Do we need this?
        double aPart = 0.0;
        for(double i=interval[0]; i<=interval[1]; i+=dist) {     //Using dist or what?
            if(i!=interval[0] && i!=interval[1]) {
                aPart += 2*p.evaluate(i);
            } else {
                aPart += p.evaluate(i);
            }
        }

        double bPart = (interval[1]-interval[0])/(2*n);

        return bPart*aPart;
    }

    public static double trapezoidalApproximationError(Polynomial p, double[] interval, int n) {
        double aPart = Math.pow(interval[1]-interval[0], 3.0);
        double bPart = 12*n*n;
        //TODO: Add function in Polynomial to calculate maximum point and maximum point on an interval


        return 0.0;
    }

    //Returns 0.0 if not even
    public static double simpsonsApproximation(Polynomial p, double[] interval, int n) {
        if(n%2!=0) {
            return 0.0;
        }
        Map<Double, Double> pTerms = p.getTerms();
        double dist = (interval[1] - interval[0])/n;    //Do we need this?
        double aPart = 0.0;
        boolean isFour = true;
        for(double i=interval[0]; i<=interval[1]; i+=dist) {     //Using dist or what?
            if(i!=interval[0] && i!=interval[1]) {
//                aPart += 2*p.evaluate(i);
                if(isFour==true) {
                    aPart += 4*p.evaluate(i);
                    isFour = false;
                } else if(isFour==false) {
                    aPart += 2*p.evaluate(i);
                    isFour = true;
                }
            } else {
                aPart += p.evaluate(i);
            }
        }

        double bPart = (interval[1]-interval[0])/(3*n);

        return bPart*aPart;
    }

    //TODO: Implement fraction support
    public static double[] integralOfTerm(Double coef, Double power) {
        double fCoef = (1.0/(power+1.0))*coef;
        double fPower = power+1.0;
        return new double[]{fCoef, fPower};
    }

    //Indef integral
    public static Polynomial integralOfPolynomial(Polynomial polynomial) {
        Map<Double, Double> pTerms = polynomial.getTerms();
        Map<Double, Double> fTerms = new HashMap();
//        for(int i=0; i<pTerms.size(); i++) {
        double[] iTerm = new double[2];
        for(Map.Entry<Double, Double> entry : pTerms.entrySet()) {
            iTerm = integralOfTerm(entry.getKey(), entry.getValue());
            fTerms.put(iTerm[0], iTerm[1]);
        }
        Polynomial p = new Polynomial(fTerms);
        return p;
    }
}
