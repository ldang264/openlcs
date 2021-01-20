import junit.framework.TestCase;
import org.junit.Assert;

public class Q00028sTest extends TestCase {
    Q00028s ss = new Q00028s();

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