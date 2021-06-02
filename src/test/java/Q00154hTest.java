import org.junit.Assert;
import org.junit.Test;

public class Q00154hTest {

    Q00154h q00154h = new Q00154h();

    @Test
    public void findMin() {
        Assert.assertEquals(q00154h.findMin(new int[]{2, 1, 2, 2, 2}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{1, 2}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}), 0);
        Assert.assertEquals(q00154h.findMin(new int[]{3, 4, 4, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, -10, -10, -10, -9, -8, -8, -8, -8, -8, -7, -7, -7, -7, -6, -6, -6, -6, -6, -6, -6, -5, -5, -5, -4, -4, -4, -4, -3, -3, -3, -3, -3, -3, -2, -2, -2, -2, -1, -1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3}), -10);
        Assert.assertEquals(q00154h.findMin(new int[]{10, 10, 10, -10, -10, -10, -10, -9, -9, -9, -9, -9, -9, -9, -8, -8, -8, -8, -8, -8, -8, -8, -7, -7, -7, -7, -6, -6, -6, -5, -5, -5, -4, -4, -4, -4, -3, -3, -2, -2, -2, -2, -2, -2, -2, -2, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 10, 10}), -10);
        Assert.assertEquals(q00154h.findMin(new int[]{0, 0, 1, 1, 2, 0}), 0);
        Assert.assertEquals(q00154h.findMin(new int[]{2, 2, 1}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{1}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{1, 1}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{2, 1, 2}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{2, 2, 1, 2}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{2, 2, 1, 2, 2, 2}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{2, 2, 2, 1, 2}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{2, 2, 1, 2, 2}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{2, 2, 2, 1, 2, 2}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{1, 2, 3}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{1, 2, 2}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{1, 2, 3, 4}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{2, 1}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{2, 3, 1}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{3, 1, 2}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{2, 3, 4, 1}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{3, 4, 1, 2}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{4, 1, 2, 3}), 1);
        Assert.assertEquals(q00154h.findMin(new int[]{3, 4, 5, 1, 2}), 1);
    }
}