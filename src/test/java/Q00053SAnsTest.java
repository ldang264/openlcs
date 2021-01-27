import org.junit.Assert;
import org.junit.Test;

public class Q00053SAnsTest {

    Q00053s_Ans q00053SAns = new Q00053s_Ans();

    @Test
    public void maxSubArray() {
        Assert.assertEquals(8, q00053SAns.maxSubArray(new int[]{-2, 5, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(6, q00053SAns.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(4, q00053SAns.maxSubArray(new int[]{-2, 1, -3, 2, -1, 1, -3, 4}));
        Assert.assertEquals(6, q00053SAns.maxSubArray(new int[]{1, -3, 2, 4, -5, 2, -1, 3, -4, 2}));
    }
}