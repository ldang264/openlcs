import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00326sTest {

    Q00326s q00326s = new Q00326s();

    @Test
    public void isPowerOfThree() {
        Assert.assertFalse(q00326s.isPowerOfThree(0));
        Assert.assertFalse(q00326s.isPowerOfThree(2));
        Assert.assertFalse(q00326s.isPowerOfThree(4));
        Assert.assertFalse(q00326s.isPowerOfThree(26));
        Assert.assertFalse(q00326s.isPowerOfThree(28));
        Assert.assertTrue(q00326s.isPowerOfThree(1));
        Assert.assertTrue(q00326s.isPowerOfThree(3));
        Assert.assertTrue(q00326s.isPowerOfThree(27));
        Assert.assertTrue(q00326s.isPowerOfThree(81));
    }
}