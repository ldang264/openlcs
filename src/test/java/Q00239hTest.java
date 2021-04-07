import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q00239hTest {

    Q00239h q00239h = new Q00239h();

    @Test
    public void maxSlidingWindow() {
        Assert.assertEquals(Arrays.toString(q00239h.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)), "[3, 3, 2, 5]");
        Assert.assertEquals(Arrays.toString(q00239h.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)),
                "[3, 3, 5, 5, 6, 7]");
        Assert.assertEquals(Arrays.toString(q00239h.maxSlidingWindow(new int[]{1}, 1)), "[1]");
        Assert.assertEquals(Arrays.toString(q00239h.maxSlidingWindow(new int[]{1, -1}, 1)), "[1, -1]");
        Assert.assertEquals(Arrays.toString(q00239h.maxSlidingWindow(new int[]{9, 11}, 2)), "[11]");
        Assert.assertEquals(Arrays.toString(q00239h.maxSlidingWindow(new int[]{4, -2}, 2)), "[4]");
    }
}