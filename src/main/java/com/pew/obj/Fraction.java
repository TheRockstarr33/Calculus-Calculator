package com.freeman.obj;

import java.util.HashMap;
import java.util.Map;

public class Fraction {

    Polynomial numerator;
    Polynomial denominator;

    public Fraction(Polynomial numerator, Polynomial denominator) {
        this.numerator = new Polynomial(numerator);
        this.denominator = new Polynomial(denominator);
    }

    public Fraction(Double numerator, Double denominator) {
        Map<Double, Double> numeratorMap = new HashMap<Double, Double>();
        numeratorMap.put(0.0, numerator);
        this.numerator = new Polynomial(numeratorMap);

        Map<Double, Double> denominatorMap = new HashMap<Double, Double>();
        denominatorMap.put(0.0, denominator);
        this.numerator = new Polynomial(denominatorMap);
    }

    //Default of xVal should be 0...
    public double getDouble(double x) {
        return numerator.evaluate(x) / denominator.evaluate(x);
    }
}
