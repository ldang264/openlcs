import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00304mTest {

    @Test
    public void test() {
        Q00304m q00304m = new Q00304m(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });

        Assert.assertEquals(q00304m.sumRegion(2, 1, 4, 3), 8);
        Assert.assertEquals(q00304m.sumRegion(1, 1, 2, 2), 11);
        Assert.assertEquals(q00304m.sumRegion(1, 2, 2, 4), 12);
    }
}