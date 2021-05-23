import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Q00031mTest {

    Q00031m q00031MAns = new Q00031m();

    @Test
    public void nextPermutation() {
        int[] nums1 = new int[]{1, 2, 3};
        q00031MAns.nextPermutation(nums1);
        Assert.assertEquals("[1, 3, 2]", Arrays.toString(nums1));

        int[] nums5 = new int[]{1, 3, 2};
        q00031MAns.nextPermutation(nums5);
        Assert.assertEquals("[2, 1, 3]", Arrays.toString(nums5));

        int[] nums6 = new int[]{3, 1, 2};
        q00031MAns.nextPermutation(nums6);
        Assert.assertEquals("[3, 2, 1]", Arrays.toString(nums6));

        int[] nums7 = new int[]{2, 1, 3};
        q00031MAns.nextPermutation(nums7);
        Assert.assertEquals("[2, 3, 1]", Arrays.toString(nums7));

        int[] nums8 = new int[]{2, 3, 1};
        q00031MAns.nextPermutation(nums8);
        Assert.assertEquals("[3, 1, 2]", Arrays.toString(nums8));

        int[] nums2 = new int[]{3, 2, 1};
        q00031MAns.nextPermutation(nums2);
        Assert.assertEquals("[1, 2, 3]", Arrays.toString(nums2));

        int[] nums3 = new int[]{1, 1, 5};
        q00031MAns.nextPermutation(nums3);
        Assert.assertEquals("[1, 5, 1]", Arrays.toString(nums3));

        int[] nums4 = new int[]{1};
        q00031MAns.nextPermutation(nums4);
        Assert.assertEquals("[1]", Arrays.toString(nums4));
    }
}