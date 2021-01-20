import org.junit.Assert;
import org.junit.Test;

public class Q00033mTest {
    Q00033m s = new Q00033m();

    @Test
    public void search() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(0, s.search(nums, 4));
        Assert.assertEquals(1, s.search(nums, 5));
        Assert.assertEquals(2, s.search(nums, 6));
        Assert.assertEquals(3, s.search(nums, 7));
        Assert.assertEquals(4, s.search(nums, 0));
        Assert.assertEquals(5, s.search(nums, 1));
        Assert.assertEquals(6, s.search(nums, 2));
        Assert.assertEquals(-1, s.search(nums, 3));
        Assert.assertEquals(-1, s.search(nums, 8));
        Assert.assertEquals(-1, s.search(nums, -1));
        Assert.assertEquals(-1, s.search(new int[]{1}, 0));
    }
}