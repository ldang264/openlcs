import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00063mTest {

    Q00063m q00063m = new Q00063m();

    @Test
    public void uniquePathsWithObstacles() {
        Assert.assertEquals(0, q00063m.uniquePathsWithObstacles(new int[][]{{1, 0}}));
        Assert.assertEquals(2, q00063m.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        Assert.assertEquals(0, q00063m.uniquePathsWithObstacles(new int[][]{{0, 1}}));
        Assert.assertEquals(1, q00063m.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }
}