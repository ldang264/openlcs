import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00562mTest {

    Q00562m q00562m = new Q00562m();

    @Test
    public void longestLine() {
        Assert.assertEquals(q00562m.longestLine(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}), 1);
        Assert.assertEquals(q00562m.longestLine(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}}), 3);
    }
}