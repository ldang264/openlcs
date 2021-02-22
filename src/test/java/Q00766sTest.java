import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00766sTest {

    Q00766s q00766s = new Q00766s();

    @Test
    public void isToeplitzMatrix1() {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        Assert.assertTrue(q00766s.isToeplitzMatrix(matrix));
    }

    @Test
    public void isToeplitzMatrix2() {
        int[][] matrix = new int[][]{{1, 2}, {3, 1}, {4, 3}};
        Assert.assertTrue(q00766s.isToeplitzMatrix(matrix));
    }

    @Test
    public void isToeplitzMatrix3() {
        int[][] matrix = new int[][]{{1, 2}, {2, 2}};
        Assert.assertFalse(q00766s.isToeplitzMatrix(matrix));
    }

    @Test
    public void isToeplitzMatrix4() {
        int[][] matrix = new int[][]{{1, 2}, {3, 2}, {4, 3}};
        Assert.assertFalse(q00766s.isToeplitzMatrix(matrix));
    }

}