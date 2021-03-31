import ans.Q00080m_Ans;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Q00026sAnsTest {

    Q00080m_Ans rd = new Q00080m_Ans();

    @Test
    public void removeDuplicates() {
        int[] nums1 = new int[]{1,1,1,2,2,3};
        int[] nums2 = new int[]{0,0,1,1,1,1,2,3,3};
        //int[] nums3 = new int[] {1, 1, 1, 2, 2, 3, 3};
        Assert.assertEquals(5, rd.removeDuplicates(nums1));
        Assert.assertEquals("[1, 1, 2, 2, 3, 3]", Arrays.toString(nums1));
        Assert.assertEquals(7, rd.removeDuplicates(nums2));
        Assert.assertEquals("[0, 0, 1, 1, 2, 3, 3, 3, 3]", Arrays.toString(nums2));
    }
}