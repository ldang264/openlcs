import org.junit.Assert;
import org.junit.Test;

public class Q00560m_Test {

    Q00560m_Ans q00560m = new Q00560m_Ans();

    @Test
    public void subarraySum() {
        Assert.assertEquals(4, q00560m.subarraySum(new int[]{5, -3, 2, 4, 3, -2, 5, 0, 1, 1}, 4));
        Assert.assertEquals(4, q00560m.subarraySum(new int[]{5, -3, 2, 4, 3, -2, 5, 0, 1, 1}, 2));
        Assert.assertEquals(4, q00560m.subarraySum(new int[]{5, -3, 2, 4, 3, -2, 5, 0, 1, 1}, 1));
        Assert.assertEquals(4, q00560m.subarraySum(new int[]{5, -3, 2, 4, 3, -2, -5, 0, 1, 1}, 0));
        Assert.assertEquals(4, q00560m.subarraySum(new int[]{5, -3, 2, 4, 3, -2, 5, 0, 1, 1}, 3));
        Assert.assertEquals(2, q00560m.subarraySum(new int[]{1, 2, 0, -3}, 0));
        Assert.assertEquals(2, q00560m.subarraySum(new int[]{1, 1, 1}, 2));
    }
}