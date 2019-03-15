import com.freeman.calc.Integral;
import com.freeman.obj.Polynomial;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


public class IntegralTest {

    @Test
    public void isTrapezoidalApproximationOk() {

        Map m1 = new HashMap();
        m1.put(1.0, 3.0);
        Polynomial p1 = new Polynomial(m1);

        double aaa = Integral.trapezoidalApproximation(p1, new double[]{1.0, 2.0}, 1);

        Map m2 = new HashMap();
        m2.put(1.0, 2.0);
        Polynomial p2 = new Polynomial(m2);

        double bbb = Integral.trapezoidalApproximation(p2, new double[]{0, 2}, 1);

        assertEquals(aaa, 4.5);
        System.out.println("Correctly solved x^3");
        assertEquals(bbb, 4.0);
        System.out.println("Correctly solved x^2");
    }

    @Test
    public void isSimpsonApproximationOk() {

        Map m1 = new HashMap();
        m1.put(1.0, 3.0);
        Polynomial p1 = new Polynomial(m1);

        double aaa = Integral.simpsonsApproximation(p1, new double[]{1.0, 2.0}, 4);

        assertEquals(aaa, 3.75);
        System.out.println("Correctly solved x^3");
    }

    @Test
    public void isDefIntegralOfPolynomialOk() {

        Map m1 = new HashMap();
        m1.put(5.0, 2.0);
        m1.put(3.0, 1.0);
        m1.put(-7.0, 0.0);
        Polynomial p1 = new Polynomial(m1);

        double aaa = Integral.defIntegralOfPolynomial(p1, new double[]{0.0, 5.0});

        assertEquals(aaa, 210.83333333333331);
    }

    @Test
    public void isIndefIntegralOfPolynomialOk() {

        Map m1 = new HashMap();
        m1.put(3.0, 1.0);
        m1.put(-7.0, 0.0);
        Polynomial p1 = new Polynomial(m1);

        Polynomial aaa = Integral.indefIntegralOfPolynomial(p1);

        Map<Double, Double> terms = new HashMap();
        terms.put(1.5, 2.0);
        terms.put(-7.0, 1.0);

        Polynomial bbb = new Polynomial(terms);

        assertEquals(aaa, bbb);
    }
}
