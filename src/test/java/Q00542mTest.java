import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00542mTest {

    Q00542m q00542m = new Q00542m();

    @Test
    public void updateMatrix() {
        Assert.assertArrayEquals(q00542m.updateMatrix(new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 1, 1}}), new int[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 4}});
        Assert.assertArrayEquals(q00542m.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}), new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        Assert.assertArrayEquals(q00542m.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}), new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}});
    }
}