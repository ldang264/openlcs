package q00231s;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsPowerOfTwoTest {
    IsPowerOfTwo ipot = new IsPowerOfTwo();

    @Test
    public void isPowerOfTwo() {
        Assert.assertTrue(ipot.isPowerOfTwo(1));
        Assert.assertTrue(ipot.isPowerOfTwo(2));
        Assert.assertTrue(ipot.isPowerOfTwo(4));
        Assert.assertTrue(ipot.isPowerOfTwo(16));
        Assert.assertFalse(ipot.isPowerOfTwo(-1));
        Assert.assertFalse(ipot.isPowerOfTwo(0));
    }
}