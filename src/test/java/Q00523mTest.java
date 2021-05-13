import org.junit.Assert;
import org.junit.Test;

public class Q00523mTest {

    Q00523m_Ans q00523m = new Q00523m_Ans();

    @Test
    public void checkSubarraySum() {
        Assert.assertTrue(q00523m.checkSubarraySum(new int[]{23, 2, 6, 4}, 6));
    }
}