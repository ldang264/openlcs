import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00494mTest {

    Q00494m q00494m = new Q00494m();

    @Test
    public void findTargetSumWays() {
        Assert.assertEquals(5, q00494m.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}