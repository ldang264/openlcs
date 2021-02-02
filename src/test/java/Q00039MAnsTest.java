import org.junit.Assert;
import org.junit.Test;

public class Q00039MAnsTest {

    Q00039m_Ans q00039MAns = new Q00039m_Ans();

    @Test
    public void combinationSum() {
        Assert.assertEquals("[[7], [2, 2, 3]]", q00039MAns.combinationSum(new int[]{2,3,6,7}, 7).toString());
        Assert.assertEquals("[[3, 5], [2, 3, 3], [2, 2, 2, 2]]", q00039MAns.combinationSum(new int[]{2,3,5}, 8).toString());
    }
}