import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00004mTest {

    J00004m j00004m = new J00004m();

    @Test
    public void findNumberIn2DArray() {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Assert.assertTrue(j00004m.findNumberIn2DArray(matrix, 1));
        Assert.assertTrue(j00004m.findNumberIn2DArray(matrix, 5));
        Assert.assertTrue(j00004m.findNumberIn2DArray(matrix, 15));
        Assert.assertTrue(j00004m.findNumberIn2DArray(matrix, 30));
        Assert.assertFalse(j00004m.findNumberIn2DArray(matrix, 20));
        Assert.assertFalse(j00004m.findNumberIn2DArray(matrix, 25));
        Assert.assertFalse(j00004m.findNumberIn2DArray(matrix, 27));
        Assert.assertFalse(j00004m.findNumberIn2DArray(matrix, 31));
    }
}