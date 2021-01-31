import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class Q00739mTest extends TestCase {

    Q00739m q00739m = new Q00739m();

    public void testDailyTemperatures() {
        Assert.assertEquals(
                "[1, 1, 4, 2, 1, 1, 0, 0]",
                Arrays.toString(q00739m.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}