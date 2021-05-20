import org.junit.Assert;
import org.junit.Test;

public class Q01438mTest {

    Q01438m_Ans q01438m = new Q01438m_Ans();

    @Test
    public void longestSubarray() {
        Assert.assertEquals(q01438m.longestSubarray(new int[]{1, 5, 6, 7, 8, 10, 6, 5, 6}, 4), 5);
        Assert.assertEquals(q01438m.longestSubarray(new int[]{8, 2, 5, 0}, 4), 2);
        Assert.assertEquals(q01438m.longestSubarray(new int[]{8, 7, 4, 2, 8, 1, 7, 7}, 8), 8);
        Assert.assertEquals(q01438m.longestSubarray(new int[]{8, 2, 4, 7}, 4), 2);
        Assert.assertEquals(q01438m.longestSubarray(new int[]{8, 2, 5, 1}, 4), 3);
        Assert.assertEquals(q01438m.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5), 4);
        Assert.assertEquals(q01438m.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0), 3);
    }
}