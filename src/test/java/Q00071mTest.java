import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00071mTest {

    Q00071m q00071m = new Q00071m();

    @Test
    public void simplifyPath() {
        Assert.assertEquals(q00071m.simplifyPath("/home//foo/"), "/home/foo");
        Assert.assertEquals(q00071m.simplifyPath("/a/./b/../../c/"), "/c");
        Assert.assertEquals(q00071m.simplifyPath("/home/"), "/home");
        Assert.assertEquals(q00071m.simplifyPath("/../"), "/");
    }
}