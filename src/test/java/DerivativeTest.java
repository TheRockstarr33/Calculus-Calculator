import com.freeman.obj.Polynomial;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.freeman.calc.Derivative.derivativeOfPolynomial;
import static com.freeman.calc.Derivative.derivativeOfTerm;

import static junit.framework.TestCase.assertEquals;

public class DerivativeTest {

    @Test
    public void isDerivativeOfTermOk() {
        double[] a = derivativeOfTerm(5.0, 4.0);
        boolean correct=true;

        if(a[0]!=20.0) {
            correct = false;
        } else if(a[1]!=3.0) {
            correct = false;
        }

        assertEquals(correct, true);
    }

    @Test
    public void isDerivativeOfPolynomialOk() {
        Map m1 = new HashMap();
        m1.put(5.0, 3.0);
        m1.put(14.0, 2.0);
        m1.put(7.0, 1.0);
        m1.put(2.0, 0.0);
        Polynomial p = new Polynomial(m1);

        Map m2 = new HashMap();
        m2.put(15.0, 2.0);
        m2.put(28.0, 1.0);
        m2.put(7.0, 0.0);
        Polynomial q = new Polynomial(m2);

        assertEquals(derivativeOfPolynomial(p), q);
    }
}
