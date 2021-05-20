import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00049mTest {

    J00049m j00049m = new J00049m();

    @Test
    public void nthUglyNumber() {
        Assert.assertEquals(j00049m.nthUglyNumber(1), 1);
        Assert.assertEquals(j00049m.nthUglyNumber(2), 2);
        Assert.assertEquals(j00049m.nthUglyNumber(3), 3);
        Assert.assertEquals(j00049m.nthUglyNumber(4), 4);
        Assert.assertEquals(j00049m.nthUglyNumber(5), 5);
        Assert.assertEquals(j00049m.nthUglyNumber(6), 6);
        Assert.assertEquals(j00049m.nthUglyNumber(7), 8);
        Assert.assertEquals(j00049m.nthUglyNumber(8), 9);
        Assert.assertEquals(j00049m.nthUglyNumber(9), 10);
        Assert.assertEquals(j00049m.nthUglyNumber(10), 12);
    }
}