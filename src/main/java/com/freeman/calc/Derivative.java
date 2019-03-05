package com.freeman.calc;

import com.freeman.obj.Polynomial;

import java.util.HashMap;
import java.util.Map;

public abstract class Derivative {

    public static double[] derivativeOfTerm(double coef, double power) {
        double fCoef = coef*power;
        double fPower = power-1.0;
        return new double[] {fCoef, fPower};
    }

    public static Polynomial derivativeOfPolynomial(Polynomial polynomial) {
        Map<Double, Double> pTerms = polynomial.getTerms();
        Map<Double, Double> fTerms = new HashMap();
        double[] dTerm = new double[2];
        for(Map.Entry<Double, Double> entry : pTerms.entrySet()) {
            dTerm = derivativeOfTerm(entry.getKey(), entry.getValue());
            if(dTerm[0] != 0.0) {
                fTerms.put(dTerm[0], dTerm[1]);
            }
        }
        Polynomial p = new Polynomial(fTerms);
        return p;
    }
}
