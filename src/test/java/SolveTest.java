import com.freeman.algbr.Solve;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SolveTest {

    @Test
    public void isSolveForXQuadraticOk() {
        List<Double> expectedList = Solve.solveForXQuadratic(2.0, 6.0, 4.0);
        List<Double> actualList = new ArrayList<Double>();
        actualList.add(-1.0);
        actualList.add(-2.0);

        assertEquals(actualList, expectedList);
    }

    @Test
    public void isSolveForXLinearOk() {
        List<Double> expectedList = Solve.solveForXLinear(4.0, 6.0);
        List<Double> actualList = new ArrayList<Double>();
        actualList.add(-1.5);

        assertEquals(actualList, expectedList);
    }
}
