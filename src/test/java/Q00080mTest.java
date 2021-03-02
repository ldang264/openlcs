import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Q00080mTest {

    Q00080m q00080m = new Q00080m();

    @Test
    public void removeDuplicates() {
        int[] nums2 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        Assert.assertEquals(q00080m.removeDuplicates(nums2), 7);
        Assert.assertEquals(Arrays.toString(nums2), "[0, 0, 1, 1, 2, 3, 3, 3, 3]");
        int[] nums0 = new int[]{1, 1, 1, 2, 2, 3};
        Assert.assertEquals(q00080m.removeDuplicates(nums0), 5);
        Assert.assertEquals(Arrays.toString(nums0), "[1, 1, 2, 2, 3, 3]");
        int[] nums1 = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        Assert.assertEquals(q00080m.removeDuplicates(nums1), 8);
        Assert.assertEquals(Arrays.toString(nums1), "[1, 1, 2, 2, 3, 3, 4, 4, 3, 4, 4, 4]");
        Assert.assertEquals(q00080m.removeDuplicates(new int[]{1, 2, 3, 4, 5}), 5);
        Assert.assertEquals(q00080m.removeDuplicates(new int[]{1, 2, 2, 4, 5}), 5);
    }
}