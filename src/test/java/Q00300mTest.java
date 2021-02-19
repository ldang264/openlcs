import org.junit.Assert;
import org.junit.Test;

public class Q00300mTest {

    Q00300m_Ans q00300m = new Q00300m_Ans();

    @Test
    public void lengthOfLIS() {
        Assert.assertEquals(1, q00300m.lengthOfLIS(new int[]{0}));
        Assert.assertEquals(6, q00300m.lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12}));
        Assert.assertEquals(6, q00300m.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        Assert.assertEquals(4, q00300m.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        Assert.assertEquals(4, q00300m.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        Assert.assertEquals(1, q00300m.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        Assert.assertEquals(4, q00300m.lengthOfLIS(new int[]{6, 8, 7, 10, 11, 5, 9}));
        Assert.assertEquals(3, q00300m.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
        Assert.assertEquals(2, q00300m.lengthOfLIS(new int[]{3, 1, 2}));
        Assert.assertEquals(1, q00300m.lengthOfLIS(new int[]{1, 0}));
        Assert.assertEquals(2, q00300m.lengthOfLIS(new int[]{0, 1}));
    }
}