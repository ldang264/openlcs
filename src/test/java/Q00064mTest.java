import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00064mTest {

    Q00064m q00064m = new Q00064m();

    @Test
    public void minPathSum() {
        Assert.assertEquals(12, q00064m.minPathSum(new int[][]{{1,2,3},{4,5,6}}));
        Assert.assertEquals(7, q00064m.minPathSum(new int[][]{{1,3,1},{1,5,1}, {4,2,1}}));
    }
}