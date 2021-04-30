import org.junit.Assert;
import org.junit.Test;

public class Q00123hTest {

    Q00123h_Ans q00123h = new Q00123h_Ans();

    @Test
    public void maxProfit() {
        Assert.assertEquals(q00123h.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}), 6);
        Assert.assertEquals(q00123h.maxProfit(new int[]{1, 2, 3, 4, 5}), 4);
        Assert.assertEquals(q00123h.maxProfit(new int[]{7, 6, 4, 3, 1}), 0);
        Assert.assertEquals(q00123h.maxProfit(new int[]{1}), 0);
    }
}