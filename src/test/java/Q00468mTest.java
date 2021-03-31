import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00468mTest {

    Q00468m q00468m = new Q00468m();

    @Test
    public void validIPAddress() {
        Assert.assertEquals(q00468m.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"), "Neither");
        Assert.assertEquals(q00468m.validIPAddress("172.16.254.1."), "Neither");
        Assert.assertEquals(q00468m.validIPAddress("172.16.254.1"), "IPv4");
        Assert.assertEquals(q00468m.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"), "IPv6");
        Assert.assertEquals(q00468m.validIPAddress("256.256.256.256"), "Neither");
        Assert.assertEquals(q00468m.validIPAddress("1e1.4.5.6"), "Neither");
        Assert.assertEquals(q00468m.validIPAddress("2001:0db8:85a3::8A2E:0370:7334"), "Neither");
        Assert.assertEquals(q00468m.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"), "Neither");
    }
}