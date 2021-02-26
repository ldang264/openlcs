import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01020mTest {

    Q01020m q01020m = new Q01020m();

    @Test
    public void numEnclaves() {
        Assert.assertEquals(0, q01020m.numEnclaves(new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}));
        Assert.assertEquals(0, q01020m.numEnclaves(new int[][]{{1}}));
        Assert.assertEquals(0, q01020m.numEnclaves(new int[][]{{0}}));
        Assert.assertEquals(0, q01020m.numEnclaves(new int[][]{{1, 0}}));
        Assert.assertEquals(0, q01020m.numEnclaves(new int[][]{{1}, {0}}));
        Assert.assertEquals(0, q01020m.numEnclaves(new int[][]{{0, 1}}));
        Assert.assertEquals(0, q01020m.numEnclaves(new int[][]{{0}, {1}}));
        Assert.assertEquals(0, q01020m.numEnclaves(new int[][]{{1, 1}}));
        Assert.assertEquals(0, q01020m.numEnclaves(new int[][]{{1}, {1}}));
        Assert.assertEquals(0, q01020m.numEnclaves(new int[][]{{1}, {0}, {1}}));
        Assert.assertEquals(0, q01020m.numEnclaves(new int[][]{{1, 0, 1}}));
    }
}