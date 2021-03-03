import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00063mTest {

    J00063m j00063m = new J00063m();

    @Test
    public void maxProfit() {
        Assert.assertEquals(j00063m.maxProfit(new int[]{10, 3, 5, 4, 8, 1, 4, 3, 7, 4}), 6);
        Assert.assertEquals(j00063m.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
        Assert.assertEquals(j00063m.maxProfit(new int[]{1, 2, 3, 4, 5, 6}), 5);
        Assert.assertEquals(j00063m.maxProfit(new int[]{7, 6, 4, 3, 1}), 0);
    }
}