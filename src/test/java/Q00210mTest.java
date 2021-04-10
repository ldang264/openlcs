import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q00210mTest {

    Q00210m q00210m = new Q00210m();

    @Test
    public void findOrder() {
        Assert.assertEquals(Arrays.toString(q00210m.findOrder(2, new int[][]{{1, 0}})), "[0, 1]");
        Assert.assertEquals(Arrays.toString(q00210m.findOrder(2, new int[][]{{1, 0}, {0, 1}})), "[]");
        Assert.assertEquals(Arrays.toString(q00210m.findOrder(4, new int[][]{{3, 1}, {3, 2}, {1, 0}, {2, 0}})), "[0, 1, 2, 3]");
    }
}