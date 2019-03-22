import com.freeman.algbr.Solve;
import com.freeman.obj.Polynomial;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class SolveTest {

    @Test
    public void isSolveForXForZeroOk() {
        Map m1 = new HashMap();
        m1.put(0.0, 0.0);
        Polynomial p1 = new Polynomial(m1);

        assertEquals(Solve.solveForX(p1, 0.0), 0.0);
    }

    @Test
    public void isSolveForXForNonZeroOk() {
        Map m1 = new HashMap();
        m1.put(4.0, 0.0);
        m1.put(5.0, 2.0);
        Polynomial p1 = new Polynomial(m1);

        assertEquals(2.0, Solve.solveForX(p1, 24.0));
    }
}
