import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00165mTest {

    Q00165m q00165m = new Q00165m();

    @Test
    public void compareVersion() {
        Assert.assertEquals(q00165m.compareVersion("1.01", "1.001"), 0);
        Assert.assertEquals(q00165m.compareVersion("1.0", "1.0.0"), 0);
        Assert.assertEquals(q00165m.compareVersion("0.1", "1.1"), -1);
        Assert.assertEquals(q00165m.compareVersion("1.0.1", "1"), 1);
        Assert.assertEquals(q00165m.compareVersion("7.5.2.4", "7.5.3"), -1);
    }
}