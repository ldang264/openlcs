package j00003s;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindRepeatNumberTest {
    FindRepeatNumber fpn = new FindRepeatNumber();

    @Test
    public void findRepeatNumber() {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int i = fpn.findRepeatNumber(nums);
        Assert.assertTrue(i == 2 || i == 3);
    }
}