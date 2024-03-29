import org.junit.Assert;
import org.junit.Test;

public class M00010_03MTest {

    M00010_03m m00010_03M = new M00010_03m();

    @Test
    public void search() {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        Assert.assertEquals(m00010_03M.search(arr, 5), 8);
        Assert.assertEquals(m00010_03M.search(new int[]{5,5,5,1,2,3,4,5}, 5), 0);
        Assert.assertEquals(m00010_03M.search(arr, 1), 5);
        Assert.assertEquals(m00010_03M.search(arr, 11), -1);
        Assert.assertEquals(m00010_03M.search(new int[]{1}, 0), -1);
        Assert.assertEquals(m00010_03M.search(new int[]{1}, 1), 0);
        Assert.assertEquals(m00010_03M.search(new int[]{1}, 2), -1);
        Assert.assertEquals(m00010_03M.search(new int[]{2, 1}, 0), -1);
        Assert.assertEquals(m00010_03M.search(new int[]{2, 1}, 1), 1);
        Assert.assertEquals(m00010_03M.search(new int[]{2, 1}, 2), 0);
        Assert.assertEquals(m00010_03M.search(new int[]{2, 1}, 3), -1);
        Assert.assertEquals(m00010_03M.search(new int[]{1, 1}, 0), -1);
        Assert.assertEquals(m00010_03M.search(new int[]{1, 1}, 1), 0);
        Assert.assertEquals(m00010_03M.search(new int[]{1, 1}, 2), -1);
        Assert.assertEquals(m00010_03M.search(new int[]{1, 2, 3}, 0), -1);
        Assert.assertEquals(m00010_03M.search(new int[]{1, 2, 3}, 1), 0);
        Assert.assertEquals(m00010_03M.search(new int[]{1, 2, 3}, 2), 1);
        Assert.assertEquals(m00010_03M.search(new int[]{1, 2, 3}, 3), 2);
        Assert.assertEquals(m00010_03M.search(new int[]{1, 2, 3}, 4), -1);
    }
}