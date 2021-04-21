import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00075mTest {

    Q00075m q00075m = new Q00075m();

    @Test
    public void sortColors() {
        int[] nums0 = new int[]{0, 1};
        q00075m.sortColors(nums0);
        Assert.assertArrayEquals(nums0, new int[]{0, 1});

        int[] nums1 = new int[]{2, 0, 2, 1, 1, 0};
        q00075m.sortColors(nums1);
        Assert.assertArrayEquals(nums1, new int[]{0, 0, 1, 1, 2, 2});

        int[] nums2 = new int[]{2, 0, 1};
        q00075m.sortColors(nums2);
        Assert.assertArrayEquals(nums2, new int[]{0, 1, 2});

        int[] nums3 = new int[]{0};
        q00075m.sortColors(nums3);
        Assert.assertArrayEquals(nums3, new int[]{0});

        int[] nums4 = new int[]{1};
        q00075m.sortColors(nums4);
        Assert.assertArrayEquals(nums4, new int[]{1});
    }
}