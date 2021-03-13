import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00043mTest {

    Q00043m q00043m = new Q00043m();

    @Test
    public void multiply() {
        Assert.assertEquals(q00043m.multiply("123", "0"), "0");
        Assert.assertEquals(q00043m.multiply("123", "456"), "56088");
        Assert.assertEquals(q00043m.multiply("2", "3"), "6");
        Assert.assertEquals(q00043m.multiply("99999999", "99"), "9899999901");
        Assert.assertEquals(q00043m.multiply("5000040", "12300"), "61500492000");
    }
}