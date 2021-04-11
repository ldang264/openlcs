import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00017_21hTest {

    M00017_21h m00017_21h = new M00017_21h();

    @Test
    public void trap() {
        Assert.assertEquals(m00017_21h.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}), 6);
        Assert.assertEquals(m00017_21h.trap(new int[]{1, 0, 2}), 1);
        Assert.assertEquals(m00017_21h.trap(new int[]{2, 0, 1}), 1);
        Assert.assertEquals(m00017_21h.trap(new int[]{0, 1, 2}), 0);
        Assert.assertEquals(m00017_21h.trap(new int[]{2, 1, 0}), 0);
        Assert.assertEquals(m00017_21h.trap(new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3}), 83);
        Assert.assertEquals(m00017_21h.trap(new int[]{9, 6, 8, 8, 5, 6, 3}), 3);
        Assert.assertEquals(m00017_21h.trap(new int[]{2, 1, 2}), 1);
        Assert.assertEquals(m00017_21h.trap(new int[]{1}), 0);
        Assert.assertEquals(m00017_21h.trap(new int[]{1, 2}), 0);
        Assert.assertEquals(m00017_21h.trap(new int[]{1, 2, 1}), 0);
        Assert.assertEquals(m00017_21h.trap(new int[]{2, 1}), 0);
        Assert.assertEquals(m00017_21h.trap(new int[]{3, 2, 4, 5}), 1);
        Assert.assertEquals(m00017_21h.trap(new int[]{5, 4, 1, 2}), 1);
        Assert.assertEquals(m00017_21h.trap(new int[]{4, 2, 0, 3, 2, 5}), 9);
        Assert.assertEquals(m00017_21h.trap(new int[]{4, 2, 0, 3, 2, 5, 1, 4}), 12);
    }
}