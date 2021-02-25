import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00053sTest {

    Q00053s q00053s = new Q00053s();

    @Test
    public void maxSubArray() {
        Assert.assertEquals(3, q00053s.maxSubArray(new int[]{1, 2}));
        Assert.assertEquals(-1, q00053s.maxSubArray(new int[]{-2, -1}));
        Assert.assertEquals(0, q00053s.maxSubArray(null));
        Assert.assertEquals(0, q00053s.maxSubArray(new int[0]));
        Assert.assertEquals(-2, q00053s.maxSubArray(new int[]{-2}));
        Assert.assertEquals(1, q00053s.maxSubArray(new int[]{-2, 1}));
        Assert.assertEquals(1, q00053s.maxSubArray(new int[]{1, -2}));
        Assert.assertEquals(8, q00053s.maxSubArray(new int[]{-2, 5, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(6, q00053s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(4, q00053s.maxSubArray(new int[]{-2, 1, -3, 2, -1, 1, -3, 4}));
        Assert.assertEquals(6, q00053s.maxSubArray(new int[]{1, -3, 2, 4, -5, 2, -1, 3, -4, 2}));
    }
}