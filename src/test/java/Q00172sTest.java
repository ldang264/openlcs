import ans.Q00172s_Ans;
import org.junit.Assert;
import org.junit.Test;

public class Q00172sTest {

    Q00172s tz = new Q00172s();

    @Test
    public void trailingZeroes() {
        Assert.assertEquals(0, tz.trailingZeroes(0));
        Assert.assertEquals(0, tz.trailingZeroes(1));
        Assert.assertEquals(0, tz.trailingZeroes(2));
        Assert.assertEquals(0, tz.trailingZeroes(3));
        Assert.assertEquals(0, tz.trailingZeroes(4));
        Assert.assertEquals(1, tz.trailingZeroes(5));
        Assert.assertEquals(1, tz.trailingZeroes(6));
        Assert.assertEquals(1, tz.trailingZeroes(7));
        Assert.assertEquals(1, tz.trailingZeroes(8));
        Assert.assertEquals(1, tz.trailingZeroes(9));
        Assert.assertEquals(2, tz.trailingZeroes(10));
        Assert.assertEquals(2, tz.trailingZeroes(11));
        Assert.assertEquals(2, tz.trailingZeroes(12));
        Assert.assertEquals(2, tz.trailingZeroes(13));
        Assert.assertEquals(2, tz.trailingZeroes(14));
        Assert.assertEquals(3, tz.trailingZeroes(15));
        Assert.assertEquals(3, tz.trailingZeroes(16));
        Assert.assertEquals(3, tz.trailingZeroes(17));
        Assert.assertEquals(3, tz.trailingZeroes(18));
        Assert.assertEquals(3, tz.trailingZeroes(19));
        Assert.assertEquals(4, tz.trailingZeroes(20));
        Assert.assertEquals(4, tz.trailingZeroes(21));
        Assert.assertEquals(6, tz.trailingZeroes(25));
        Assert.assertEquals(7, tz.trailingZeroes(30));
    }

    Q00172s_Ans tzAns = new Q00172s_Ans();

    @Test
    public void trailingZeroes_Ans() {
        Assert.assertEquals(0, tzAns.trailingZeroes(0));
        Assert.assertEquals(0, tzAns.trailingZeroes(1));
        Assert.assertEquals(0, tzAns.trailingZeroes(2));
        Assert.assertEquals(0, tzAns.trailingZeroes(3));
        Assert.assertEquals(0, tzAns.trailingZeroes(4));
        Assert.assertEquals(1, tzAns.trailingZeroes(5));
        Assert.assertEquals(1, tzAns.trailingZeroes(6));
        Assert.assertEquals(1, tzAns.trailingZeroes(7));
        Assert.assertEquals(1, tzAns.trailingZeroes(8));
        Assert.assertEquals(1, tzAns.trailingZeroes(9));
        Assert.assertEquals(2, tzAns.trailingZeroes(10));
        Assert.assertEquals(2, tzAns.trailingZeroes(11));
        Assert.assertEquals(2, tzAns.trailingZeroes(12));
        Assert.assertEquals(2, tzAns.trailingZeroes(13));
        Assert.assertEquals(2, tzAns.trailingZeroes(14));
        Assert.assertEquals(3, tzAns.trailingZeroes(15));
        Assert.assertEquals(3, tzAns.trailingZeroes(16));
        Assert.assertEquals(3, tzAns.trailingZeroes(17));
        Assert.assertEquals(3, tzAns.trailingZeroes(18));
        Assert.assertEquals(3, tzAns.trailingZeroes(19));
        Assert.assertEquals(4, tzAns.trailingZeroes(20));
        Assert.assertEquals(4, tzAns.trailingZeroes(21));
        Assert.assertEquals(6, tzAns.trailingZeroes(25));
        Assert.assertEquals(7, tzAns.trailingZeroes(30));
    }
}