import org.junit.Assert;
import org.junit.Test;

public class Q00307MAnsTest {

    @Test
    public void test() {
        Q00307m_Ans numArray = new Q00307m_Ans(new int[]{1, 3, 5});
        Assert.assertEquals(9, numArray.sumRange(0, 2)); // 返回 9 ，sum([1,3,5]) = 9
        numArray.update(1, 2);   // nums = [1,2,5]
        Assert.assertEquals(8, numArray.sumRange(0, 2)); // 返回 8 ，sum([1,2,5]) = 9
    }

}