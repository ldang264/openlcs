import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Q00283sTest {
    Q00283s mz = new Q00283s();

    @Test
    public void moveZeroes() {
        int[] nums = new int[]{0 , 1, 0, 3, 2};
        mz.moveZeroes(nums);
        Assert.assertEquals("[1, 3, 2, 0, 0]", Arrays.toString(nums));

        nums = new int[]{0};
        mz.moveZeroes(nums);
        Assert.assertEquals("[0]", Arrays.toString(nums));

        nums = new int[]{1};
        mz.moveZeroes(nums);
        Assert.assertEquals("[1]", Arrays.toString(nums));

        nums = new int[]{1, 0, 2, 0, 3, 0};
        mz.moveZeroes(nums);
        Assert.assertEquals("[1, 2, 3, 0, 0, 0]", Arrays.toString(nums));
    }
}