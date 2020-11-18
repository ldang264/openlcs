package q00189m;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Array_RotateTest {
    Array_Rotate r = new Array_Rotate();

    @Test
    public void rotate() {
        int[] nums1 = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums1, 0);
        Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7]", Arrays.toString(nums1));

        nums1 = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums1, 1);
        Assert.assertEquals("[7, 1, 2, 3, 4, 5, 6]", Arrays.toString(nums1));

        nums1 = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums1, 2);
        Assert.assertEquals("[6, 7, 1, 2, 3, 4, 5]", Arrays.toString(nums1));

        nums1 = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums1, 3);
        Assert.assertEquals("[5, 6, 7, 1, 2, 3, 4]", Arrays.toString(nums1));

        nums1 = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums1, 4);
        Assert.assertEquals("[4, 5, 6, 7, 1, 2, 3]", Arrays.toString(nums1));

        nums1 = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums1, 5);
        Assert.assertEquals("[3, 4, 5, 6, 7, 1, 2]", Arrays.toString(nums1));

        nums1 = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums1, 6);
        Assert.assertEquals("[2, 3, 4, 5, 6, 7, 1]", Arrays.toString(nums1));

        nums1 = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums1, 7);
        Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7]", Arrays.toString(nums1));

        nums1 = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums1, 8);
        Assert.assertEquals("[7, 1, 2, 3, 4, 5, 6]", Arrays.toString(nums1));

        nums1 = new int[]{1,2,3,4,5,6,7};
        r.rotate(nums1, 14);
        Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7]", Arrays.toString(nums1));
    }

    @Test
    public void rotate1() {
        int[] nums1 = new int[]{1, 2, 3, 4};
        r.rotate(nums1, 1);
        Assert.assertEquals("[4, 1, 2, 3]", Arrays.toString(nums1));

        nums1 = new int[]{1, 2, 3, 4};
        r.rotate(nums1, 2);
        Assert.assertEquals("[3, 4, 1, 2]", Arrays.toString(nums1));

        nums1 = new int[]{1, 2, 3, 4};
        r.rotate(nums1, 3);
        Assert.assertEquals("[2, 3, 4, 1]", Arrays.toString(nums1));
    }
}