import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class M17_14mTest {

    M17_14m m17_14m = new M17_14m();

    @Test
    public void smallestK() {
        Assert.assertEquals(Arrays.toString(m17_14m.smallestK(new int[0], 0)), "[]");
        Assert.assertEquals(Arrays.toString(m17_14m.smallestK(new int[]{1}, 0)), "[]");
        Assert.assertEquals(Arrays.toString(m17_14m.smallestK(new int[]{1}, 1)), "[1]");
        Assert.assertEquals(Arrays.toString(m17_14m.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)),
                "[1, 2, 3, 4]");
    }
}