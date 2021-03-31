import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00121sTest {

    Q00121s q00121s = new Q00121s();

    @Test
    public void maxProfit() {
        Assert.assertEquals(q00121s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
        Assert.assertEquals(q00121s.maxProfit(new int[]{1, 2, 3, 4, 5}), 4);
        Assert.assertEquals(q00121s.maxProfit(new int[]{7, 6, 4, 3, 1}), 0);
    }
}