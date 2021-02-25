import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Q00350sTest {

    Q00350s q00350s = new Q00350s();

    @Test
    public void intersect() {
        Assert.assertEquals("[]", Arrays.toString(q00350s.intersect(null, null)));
        Assert.assertEquals("[]", Arrays.toString(q00350s.intersect(new int[0], new int[]{1})));
        Assert.assertEquals("[]", Arrays.toString(q00350s.intersect(new int[0], null)));
        Assert.assertEquals("[]", Arrays.toString(q00350s.intersect(new int[]{1}, null)));
        Assert.assertEquals("[2, 2]", Arrays.toString(q00350s.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        Assert.assertEquals("[9, 4]", Arrays.toString(q00350s.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}