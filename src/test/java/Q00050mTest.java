import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00050mTest {

    Q00050m q00050m = new Q00050m();

    @Test
    public void test() {
        double x1 = 2.00000, x2 = 2.10000, x3 = 2.00000, x4 = 0.00001,    x5 = 1.00000,     x6 = 34.00515;
        int    n1 = 10     , n2 = 3      , n3 = -2,      n4 = 2147483647, n5 = -2147483648, n6 = -3;
        Assert.assertEquals(q00050m.myPow(x1, n1), 1024.00000, 5);
        Assert.assertEquals(q00050m.myPow(x2, n2), 9.26100, 5);
        Assert.assertEquals(q00050m.myPow(x3, n3), 0.25000, 5);
        Assert.assertEquals(q00050m.myPow(x4, n4), 0, 5);
        Assert.assertEquals(q00050m.myPow(x5, n5), 1, 5);
        Assert.assertEquals(q00050m.myPow(x6, n6), 0.00003, 5);
    }
}