import org.junit.Test;

import static org.junit.Assert.*;

public class Q00088sTest {

    Q00088s q00088s = new Q00088s();

    @Test
    public void merge() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        q00088s.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        int[] nums2 = {2, 0};
        q00088s.merge(nums2, 1, new int[]{1}, 1);
        int[] nums3 = {2, 0};
        q00088s.merge(nums3, 1, new int[]{1}, 0);
        int[] nums4 = new int[]{1, 2, 3, 0, 0};
        q00088s.merge(nums4, 3, new int[]{2, 6}, 2);
        System.out.println(1);
    }
}