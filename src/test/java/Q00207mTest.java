import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00207mTest {

    Q00207m q00207m = new Q00207m();

    @Test
    public void canFinish() {
        Assert.assertTrue(q00207m.canFinish(2, new int[][]{{1, 0}}));
        Assert.assertFalse(q00207m.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        Assert.assertTrue(q00207m.canFinish(4, new int[][]{{3, 1}, {3, 2}, {1, 0}, {2, 0}}));
    }
}