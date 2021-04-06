import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00560mTest {

    Q00560m q00560m = new Q00560m();

    @Test
    public void subarraySum() {
        Assert.assertEquals(q00560m.subarraySum(new int[]{3, 0}, 3), 2);
        Assert.assertEquals(q00560m.subarraySum(new int[]{0, 1, 0, 0, 0, -1, 0}, 0), 12);
        // 0 1 -> 0 2 -> 0 3
        Assert.assertEquals(q00560m.subarraySum(new int[]{0, 0, 0}, 0), 6);
        // 0 1 -> 0 1, 1 1 -> 0 1, 1 1, 3 1 -> 0 1, 1 1, 3 2
        Assert.assertEquals(q00560m.subarraySum(new int[]{1, 2, 3}, 3), 2);
        Assert.assertEquals(q00560m.subarraySum(new int[]{0, 1, -1}, 0), 3);
        Assert.assertEquals(q00560m.subarraySum(new int[]{1, 1, 1}, 2), 2);
    }
}