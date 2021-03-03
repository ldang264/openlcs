import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00050mTest {

    J00050m j00050m = new J00050m();

    @Test
    public void myPow() {
        Assert.assertEquals(j00050m.myPow(0, 0), 0, 5);
        Assert.assertEquals(j00050m.myPow(2.00000, 1), 2.00000, 5);
        Assert.assertEquals(j00050m.myPow(2.00000, 0), 1.00000, 5);
        Assert.assertEquals(j00050m.myPow(2.00000, -1), 0.50000, 5);
        Assert.assertEquals(j00050m.myPow(2.00000, 10), 1024.00000, 5);
        Assert.assertEquals(j00050m.myPow(2.10000, 3), 9.26100, 5);
        Assert.assertEquals(j00050m.myPow(2.00000, -2), 0.25000, 5);
    }
}