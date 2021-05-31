import org.junit.Assert;
import org.junit.Test;

public class Q00122sTest {

    Q00122s q00122s = new Q00122s();

    @Test
    public void maxProfit() {
        Assert.assertEquals(q00122s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 7);
        Assert.assertEquals(q00122s.maxProfit(new int[]{1, 2, 3, 4, 5}), 4);
        Assert.assertEquals(q00122s.maxProfit(new int[]{7, 6, 4, 3, 1}), 0);
    }
}