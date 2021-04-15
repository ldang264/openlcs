import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00310mTest {

    Q00310m q00310m = new Q00310m();

    @Test
    public void findMinHeightTrees() {
        Assert.assertEquals(q00310m.findMinHeightTrees(1, new int[0][0]).toString(), "[0]");
        Assert.assertEquals(q00310m.findMinHeightTrees(2, new int[][]{{0, 1}}).toString(), "[0, 1]");
        Assert.assertEquals(q00310m.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}).toString(), "[1]");
        Assert.assertEquals(q00310m.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}).toString(), "[3, 4]");
    }
}