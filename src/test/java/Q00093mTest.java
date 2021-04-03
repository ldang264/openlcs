import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00093mTest {

    Q00093m q00093m = new Q00093m();

    @Test
    public void restoreIpAddresses() {
        Assert.assertEquals(q00093m.restoreIpAddresses("255255255255").toString(), "[255.255.255.255]");
        Assert.assertEquals(q00093m.restoreIpAddresses("010010").toString(), "[0.10.0.10, 0.100.1.0]");
        Assert.assertEquals(q00093m.restoreIpAddresses("0000").toString(), "[0.0.0.0]");
        Assert.assertEquals(q00093m.restoreIpAddresses("25525511135").toString(), "[255.255.11.135, 255.255.111.35]");
        Assert.assertEquals(q00093m.restoreIpAddresses("1111").toString(), "[1.1.1.1]");
        Assert.assertEquals(q00093m.restoreIpAddresses("000").toString(), "[]");
        Assert.assertEquals(q00093m.restoreIpAddresses("101023").toString(), "[1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]");
    }
}