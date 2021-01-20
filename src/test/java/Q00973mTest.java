import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Q00973mTest {

    Q00973m k = new Q00973m();

    @Test
    public void kClosest() {
        int[][] ans = k.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        Assert.assertEquals("[[-2, 2]]", Arrays.deepToString(ans));
    }

    @Test
    public void kClosest1() {
        int[][] ans = k.kClosest(new int[][]{{3,3},{5,-1}, {-2,4}}, 2);
        Assert.assertEquals("[[3, 3], [-2, 4]]", Arrays.deepToString(ans));
    }
}