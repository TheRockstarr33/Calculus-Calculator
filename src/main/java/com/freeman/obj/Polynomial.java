package com.freeman.obj;

import com.freeman.calc.Derivative;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {

    //TODO: Add fraction support in polynomials
    //TODO: Add trig support in polynomials

    //This map contains info about coefficient and power
    private Map<Double, Double> terms = new HashMap();

    //5.1x^2+3.715x-7
    //3x^2+2x+1
    public Polynomial(String f) {
        f = f.replace("-", "&-");
        String[] t = f.split("[\\+\\&]");
        for(int i=0; i<t.length; i++) {
            if(t[i].contains("x^")) {
                t[i] = t[i].replace("x", "");
                String[] temp = t[i].split("\\^");
                if(temp[0].equals("-")) {                          //TODO: Implement this for everything else!
                    temp[0] = "-1.0";
                } else if(temp[0].equals("+")) {
                    temp[0] = "1.0";
                }
                terms.put(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]));
            } else if(t[i].contains("x")) {
                t[i] = t[i].replace("x", "");
                terms.put(Double.parseDouble(t[i]), 1.0);
            } else {
                terms.put(Double.parseDouble(t[i]), 0.0);
            }
        }
    }

    public Polynomial(Map<Double, Double> terms) {
        this.terms = terms;
    }



    public double evaluate(double x) {
        double fVal = 0.0;
        for(Map.Entry<Double, Double> entry : terms.entrySet()) {
            fVal += entry.getKey()*(Math.pow(x, entry.getValue()));
        }
        return fVal;
    }

//    public double getMaxPoint() {
//        Polynomial d = Derivative.derivativeOfPolynomial(this);
//
//    }

    public void printPolynomialParts() {
        System.out.println(terms.toString());
    }

    public String getPolynomialText() {
        String a = "";
        Double recentVal = 0.0;
        for(Map.Entry<Double, Double> entry : terms.entrySet()) {
            a += entry.getKey() + "x^" + entry.getValue();
            if(!entry.getKey().toString().contains("-")) {
                a += "+";
            }
        }
        return a;
    }

    public Map<Double, Double> getTerms() {
        return terms;
    }
}
