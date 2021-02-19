import org.junit.Assert;
import org.junit.Test;

public class Q00240mTest {

    Q00240m_Ans q00240m = new Q00240m_Ans();

    @Test
    public void searchMatrix() {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        Assert.assertFalse(q00240m.searchMatrix(matrix, 0));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 1));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 2));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 3));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 4));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 5));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 6));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 7));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 8));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 9));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 10));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 11));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 12));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 13));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 14));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 15));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 16));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 17));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 18));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 19));
        Assert.assertFalse(q00240m.searchMatrix(matrix, 20));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 21));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 22));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 23));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 24));
        Assert.assertFalse(q00240m.searchMatrix(matrix, 25));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 26));
        Assert.assertFalse(q00240m.searchMatrix(matrix, 27));
        Assert.assertFalse(q00240m.searchMatrix(matrix, 28));
        Assert.assertFalse(q00240m.searchMatrix(matrix, 29));
        Assert.assertTrue(q00240m.searchMatrix(matrix, 30));
        Assert.assertFalse(q00240m.searchMatrix(matrix, 31));
    }

    @Test
    public void searchMatrix1() {
        int[][] matrix = new int[][]{{1,3, 5}};
        Assert.assertTrue(q00240m.searchMatrix(matrix, 1));
        Assert.assertFalse(q00240m.searchMatrix(matrix, 2));
    }

    @Test
    public void searchMatrix2() {
        int[][] matrix = new int[][]{{4,7,10,10,12,17,18,22,23,24}, {7,9,10,15,18,22,22,25,27,27},{8,10,11,17,23,23,23,30,34,36}};
        Assert.assertTrue(q00240m.searchMatrix(matrix, 4));
    }

    @Test
    public void searchMatrix3() {
        int[][] matrix = new int[][]{{-1, 3}};
        Assert.assertTrue(q00240m.searchMatrix(matrix, 3));
    }

    @Test
    public void searchMatrix4() {
        int[][] matrix = new int[][]{{4,5,10,15,19,20,20},{4,9,12,15,22,23,26},{7,11,12,20,25,27,27},{10,14,17,23,27,30,32},{11,18,19,24,28,34,39}};
        Assert.assertTrue(q00240m.searchMatrix(matrix, 25));
    }

    @Test
    public void searchMatrix5() {
        int[][] matrix = new int[][]{{3,6,9,12,17,22},{5,11,11,16,22,26},{10,11,14,16,24,31},{10,15,17,17,29,31},{14,17,20,23,34,37},{19,21,22,28,37,40},{22,22,24,32,37,43}};
        Assert.assertTrue(q00240m.searchMatrix(matrix, 20));
    }

}