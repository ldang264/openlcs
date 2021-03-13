import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00045mTest {

    Q00045m q00045m = new Q00045m();

    @Test
    public void jump() {
        Assert.assertEquals(q00045m.jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}), 2);
        Assert.assertEquals(q00045m.jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}), 3);
        Assert.assertEquals(q00045m.jump(new int[]{2, 1, 1, 1, 1}), 3);
        Assert.assertEquals(q00045m.jump(new int[]{3, 4, 3, 2, 5, 4, 3}), 3);
        Assert.assertEquals(q00045m.jump(new int[]{1, 1, 1, 1}), 3);
        Assert.assertEquals(q00045m.jump(new int[]{2, 3, 1, 1, 4}), 2);
        Assert.assertEquals(q00045m.jump(new int[]{1, 2, 1, 0}), 2);
    }
}