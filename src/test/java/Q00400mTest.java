import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00400mTest {

    Q00400m q00400m = new Q00400m();

    @Test
    public void findNthDigit() {
        Assert.assertEquals(q00400m.findNthDigit(Integer.MAX_VALUE), 2);
        Assert.assertEquals(q00400m.findNthDigit(10), 1);
        Assert.assertEquals(q00400m.findNthDigit(1), 1);
        Assert.assertEquals(q00400m.findNthDigit(9), 9);
        Assert.assertEquals(q00400m.findNthDigit(11), 0);
        Assert.assertEquals(q00400m.findNthDigit(13), 1);
    }
}