import org.junit.Assert;
import org.junit.Test;

public class Q00307mTest {

    @Test
    public void test() {
        Q00307m numArray = new Q00307m(new int[]{1, 3, 5, 4, 2});
        Assert.assertEquals(9, numArray.sumRange(0, 2)); // 返回 9 ，sum([1,3,5]) = 9
        Assert.assertEquals(13, numArray.sumRange(0, 3)); // 返回 9 ，sum([1,3,5]) = 9
        Assert.assertEquals(6, numArray.sumRange(3, 4)); // 返回 9 ，sum([1,3,5]) = 9
        numArray.update(1, 2);   // nums = [1,2,5]
        Assert.assertEquals(8, numArray.sumRange(0, 2)); // 返回 8 ，sum([1,2,5]) = 9
        Assert.assertEquals(12, numArray.sumRange(0, 3)); // 返回 8 ，sum([1,2,5]) = 9
    }

}