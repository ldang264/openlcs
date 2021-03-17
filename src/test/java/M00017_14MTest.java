import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class M00017_14MTest {

    M00017_14m m00017_14M = new M00017_14m();

    @Test
    public void smallestK() {
        Assert.assertEquals(Arrays.toString(m00017_14M.smallestK(new int[0], 0)), "[]");
        Assert.assertEquals(Arrays.toString(m00017_14M.smallestK(new int[]{1}, 0)), "[]");
        Assert.assertEquals(Arrays.toString(m00017_14M.smallestK(new int[]{1}, 1)), "[1]");
        Assert.assertEquals(Arrays.toString(m00017_14M.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)),
                "[1, 2, 3, 4]");
    }
}