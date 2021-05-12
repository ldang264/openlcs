import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00525mTest {

    Q00525m q00525m = new Q00525m();

    @Test
    public void findMaxLength() {
        Assert.assertEquals(q00525m.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}), 6);
        Assert.assertEquals(q00525m.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0}), 2);
        Assert.assertEquals(q00525m.findMaxLength(new int[]{0, 1}), 2);
        Assert.assertEquals(q00525m.findMaxLength(new int[]{0, 1, 0}), 2);
        Assert.assertEquals(q00525m.findMaxLength(new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 0}), 10);
        Assert.assertEquals(q00525m.findMaxLength(new int[]{0, 0, 0, 0, 1, 1, 1, 1, 0, 1}), 10);
    }
}