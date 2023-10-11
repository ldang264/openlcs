import org.junit.Assert;
import org.junit.Test;

public class J00003sTest {

    @Test
    public void findRepeatNumber() {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int i = new J00003s().findRepeatNumber(nums);
        Assert.assertTrue(i == 2 || i == 3);
    }
}
