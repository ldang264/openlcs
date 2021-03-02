import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00081mTest {

    Q00081m q00081m = new Q00081m();

    @Test
    public void search() {
        int[] nums = new int[]{3, 3, 5, 5, 6, 6, 0, 0, 1, 1, 3, 3};
        Assert.assertTrue(q00081m.search(nums, 5));
        Assert.assertTrue(q00081m.search(nums, 6));
        Assert.assertTrue(q00081m.search(nums, 0));
        Assert.assertTrue(q00081m.search(nums, 1));
        Assert.assertTrue(q00081m.search(nums, 3));
        Assert.assertFalse(q00081m.search(nums, -1));
        Assert.assertFalse(q00081m.search(nums, 2));
        Assert.assertFalse(q00081m.search(nums, 4));
        Assert.assertFalse(q00081m.search(nums, 7));
    }

    @Test
    public void search1() {
        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        Assert.assertTrue(q00081m.search(nums, 5));
        Assert.assertTrue(q00081m.search(nums, 6));
        Assert.assertTrue(q00081m.search(nums, 0));
        Assert.assertTrue(q00081m.search(nums, 1));
        Assert.assertTrue(q00081m.search(nums, 2));
        Assert.assertFalse(q00081m.search(nums, -1));
        Assert.assertFalse(q00081m.search(nums, 3));
        Assert.assertFalse(q00081m.search(nums, 4));
        Assert.assertFalse(q00081m.search(nums, 7));
    }

    @Test
    public void search2() {
        int[] nums = new int[]{1, 0, 1, 1, 1};
        Assert.assertTrue(q00081m.search(nums, 0));
        Assert.assertTrue(q00081m.search(nums, 1));
        Assert.assertFalse(q00081m.search(nums, -1));
        Assert.assertFalse(q00081m.search(nums, 2));
    }

}