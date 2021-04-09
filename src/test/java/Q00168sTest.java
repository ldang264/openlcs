import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00168sTest {
    Q00168s q00168s = new Q00168s();

    @Test
    public void convertToTitle() {
        Assert.assertEquals(q00168s.convertToTitle(52), "AZ");
        Assert.assertEquals(q00168s.convertToTitle(701), "ZY");
        Assert.assertEquals(q00168s.convertToTitle(26), "Z");
        Assert.assertEquals(q00168s.convertToTitle(1), "A");
        Assert.assertEquals(q00168s.convertToTitle(27), "AA");
        Assert.assertEquals(q00168s.convertToTitle(28), "AB");
        Assert.assertEquals(q00168s.convertToTitle(702), "ZZ");
    }
}