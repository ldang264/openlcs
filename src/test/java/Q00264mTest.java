import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00264mTest {

    Q00264m q00264m = new Q00264m();

    @Test
    public void nthUglyNumber() {
        Assert.assertEquals(q00264m.nthUglyNumber(10), 12);
        Assert.assertEquals(q00264m.nthUglyNumber(1), 1);
    }
}