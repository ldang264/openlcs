import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00004_01mTest {
    
    M00004_01m m00004_01m = new M00004_01m();

    @Test
    public void findWhetherExistsPath() {
        Assert.assertFalse(m00004_01m.findWhetherExistsPath(2, new int[][]{{0, 1}}, 0, 0));
        Assert.assertTrue(m00004_01m.findWhetherExistsPath(2, new int[][]{{0, 1}}, 0, 1));
        Assert.assertFalse(m00004_01m.findWhetherExistsPath(2, new int[][]{{1, 0}}, 0, 1));
        Assert.assertTrue(m00004_01m.findWhetherExistsPath(3, new int[][]{{0, 1}, {0, 1}, {0, 2}, {1, 2}, {1, 2}}, 0, 2));
        Assert.assertTrue(m00004_01m.findWhetherExistsPath(3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 2}}, 0, 2));
        Assert.assertTrue(m00004_01m.findWhetherExistsPath(5, new int[][]{{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}}, 0, 4));
    }
}