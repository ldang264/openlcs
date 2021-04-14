import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00091mTest {

    Q00091m q00091m = new Q00091m();

    @Test
    public void numDecodings() {
        Assert.assertEquals(q00091m.numDecodings("301"), 0);
        Assert.assertEquals(q00091m.numDecodings("10011"), 0);
        Assert.assertEquals(q00091m.numDecodings("2101"), 1);
        Assert.assertEquals(q00091m.numDecodings("10"), 1);
        Assert.assertEquals(q00091m.numDecodings("111111111111111111111111111111111111111111111"), 1836311903);
        Assert.assertEquals(q00091m.numDecodings("27"), 1);
        Assert.assertEquals(q00091m.numDecodings("12"), 2);
        Assert.assertEquals(q00091m.numDecodings("226"), 3);
        Assert.assertEquals(q00091m.numDecodings("0"), 0);
        Assert.assertEquals(q00091m.numDecodings("06"), 0);
    }
}