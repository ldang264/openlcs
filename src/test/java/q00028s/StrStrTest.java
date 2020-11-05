package q00028s;

import junit.framework.TestCase;
import org.junit.Assert;

public class StrStrTest extends TestCase {
    StrStr ss = new StrStr();

    public void testStrStr() {
        Assert.assertEquals(-1, ss.strStr(null, ""));
        Assert.assertEquals(0, ss.strStr("123", null));
        Assert.assertEquals(0, ss.strStr("123", ""));
        Assert.assertEquals(-1, ss.strStr("123", "4"));
        Assert.assertEquals(0, ss.strStr("123", "1"));
        Assert.assertEquals(2, ss.strStr("123", "3"));
        Assert.assertEquals(4, ss.strStr("mississippi", "issip"));
    }
}