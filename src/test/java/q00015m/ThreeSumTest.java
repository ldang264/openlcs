package q00015m;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ThreeSumTest {
    ThreeSum ts = new ThreeSum();

    @Test
    public void threeSum() {
        List<List<Integer>> lists = ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Assert.assertEquals("[[-1, -1, 2], [-1, 0, 1]]", lists.toString());
    }

    @Test
    public void threeSum1() {
        List<List<Integer>> lists = ts.threeSum(new int[]{0,0,0,0});
        Assert.assertEquals("[[0, 0, 0]]", lists.toString());
    }
}