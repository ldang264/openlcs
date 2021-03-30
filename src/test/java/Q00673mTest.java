import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00673mTest {

    Q00673m q00673m = new Q00673m();

    @Test
    public void findNumberOfLIS() {
        Assert.assertEquals(q00673m.findNumberOfLIS(new int[]{0, 1, 0, 3, 2, 3}), 1);
        Assert.assertEquals(q00673m.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}), 2);
        Assert.assertEquals(q00673m.findNumberOfLIS(new int[]{1, 1, 1, 1, 1}), 5);
    }
}