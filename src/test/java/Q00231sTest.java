import org.junit.Assert;
import org.junit.Test;

public class Q00231sTest {
    Q00231s ipot = new Q00231s();

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