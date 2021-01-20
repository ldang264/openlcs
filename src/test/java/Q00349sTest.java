import org.junit.Assert;
import org.junit.Test;

public class Q00349sTest {

    private Q00349s i = new Q00349s();

    @Test
    public void intersection1() {
        int[] nums1 = new int[]{1,2,2,1}, nums2 = new int[]{2,2};
        Assert.assertArrayEquals(new int[]{2}, i.intersection(nums1, nums2));
    }

    @Test
    public void intersection2() {
        int[] nums1 = new int[]{4,9,5}, nums2 = new int[]{9,4,9,8,4};
        Assert.assertArrayEquals(new int[]{9,4}, i.intersection(nums1, nums2));
    }
}