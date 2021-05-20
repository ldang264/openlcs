import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q00480hTest {

    Q00480h q00480h = new Q00480h();

    @Test
    public void medianSlidingWindow() {
        Assert.assertEquals(Arrays.toString(q00480h.medianSlidingWindow(new int[]{2147483647,1,2,3,4,5,6,7,2147483647}, 2)), "[1.073741824E9, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 1.073741827E9]");
        Assert.assertEquals(Arrays.toString(q00480h.medianSlidingWindow(new int[]{1, 1, 1, 1}, 1)), "[1.0, 1.0, 1.0, 1.0]");
        Assert.assertEquals(Arrays.toString(q00480h.medianSlidingWindow(new int[]{1, 1, 1, 1}, 2)), "[1.0, 1.0, 1.0]");
        Assert.assertEquals(Arrays.toString(q00480h.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)), "[1.0, -1.0, -1.0, 3.0, 5.0, 6.0]");
        Assert.assertEquals(Arrays.toString(q00480h.medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3)), "[2.0, 3.0, 3.0, 3.0, 2.0, 3.0, 2.0]");
        Assert.assertEquals(Arrays.toString(q00480h.medianSlidingWindow(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, 2)), "[2.147483647E9]");
    }
}