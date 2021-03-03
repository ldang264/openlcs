import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00067mTest {

    J00067m j00067m = new J00067m();

    @Test
    public void strToInt() {
        Assert.assertEquals(j00067m.strToInt("-2147483647"), -2147483647);
        Assert.assertEquals(j00067m.strToInt("  0000000000012345678"), 12345678);
        Assert.assertEquals(j00067m.strToInt("  0000000000012340678"), 12340678);
        Assert.assertEquals(j00067m.strToInt("20000000000000000000"), 2147483647);
        Assert.assertEquals(j00067m.strToInt("-20000000000000000000"), -2147483648);
        Assert.assertEquals(j00067m.strToInt("-2147483648"), -2147483648);
        Assert.assertEquals(j00067m.strToInt("42"), 42);
        Assert.assertEquals(j00067m.strToInt("+1"), 1);
        Assert.assertEquals(j00067m.strToInt("+1+"), 1);
        Assert.assertEquals(j00067m.strToInt("   -42"), -42);
        Assert.assertEquals(j00067m.strToInt("4193 with words"), 4193);
        Assert.assertEquals(j00067m.strToInt("words and 987"), 0);
        Assert.assertEquals(j00067m.strToInt("-91283472332"), -2147483648);
        Assert.assertEquals(j00067m.strToInt("2147483648"), 2147483647);
        Assert.assertEquals(j00067m.strToInt("2147483647"), 2147483647);
    }
}