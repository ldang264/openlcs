import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00029mTest {

    Q00029m q00029m = new Q00029m();

    @Test
    public void divide() {
        Assert.assertEquals(q00029m.divide(Integer.MIN_VALUE, 2), -1073741824);
        Assert.assertEquals(q00029m.divide(Integer.MAX_VALUE, 2), 1073741823);
        Assert.assertEquals(q00029m.divide(1, 1), 1);
        Assert.assertEquals(q00029m.divide(10716536, -54), -198454);
        Assert.assertEquals(q00029m.divide(Integer.MIN_VALUE, -1), Integer.MAX_VALUE);
        Assert.assertEquals(q00029m.divide(0, 3), 0);
        Assert.assertEquals(q00029m.divide(1, 3), 0);
        Assert.assertEquals(q00029m.divide(100, 3), 33);
        Assert.assertEquals(q00029m.divide(-100, 3), -33);
        Assert.assertEquals(q00029m.divide(10, 3), 3);
        Assert.assertEquals(q00029m.divide(7, -3), -2);
    }
}