import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00628sTest {

    Q00628s q00628s = new Q00628s();

    @Test
    public void maximumProduct() {
        Assert.assertEquals(6, q00628s.maximumProduct(new int[]{1, 2, 3}));
        Assert.assertEquals(24, q00628s.maximumProduct(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(-6, q00628s.maximumProduct(new int[]{-1, -2, -3}));
        Assert.assertEquals(60, q00628s.maximumProduct(new int[]{-6, -5, 0, 1, 2}));
        Assert.assertEquals(0, q00628s.maximumProduct(new int[]{-6, -5, -1, 0, 0}));
        Assert.assertEquals(-24, q00628s.maximumProduct(new int[]{-6, -5, -4, -3, -2}));
        Assert.assertEquals(12, q00628s.maximumProduct(new int[]{-3, -2, 1, 2}));
    }
}