import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00547mTest {

    Q00547m q00547m = new Q00547m();

    @Test
    public void findCircleNum() {
        Assert.assertEquals(q00547m.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}), 1);
        Assert.assertEquals(q00547m.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}), 2);
        Assert.assertEquals(q00547m.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}), 3);
    }
}