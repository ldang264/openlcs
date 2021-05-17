import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00007sTest {

    Q00007s main = new Q00007s();
    
    @Test
    public void reverse() {
        Assert.assertEquals(main.reverse(123), 321);
        Assert.assertEquals(main.reverse(-123), -321);
        Assert.assertEquals(main.reverse(120), 21);
        Assert.assertEquals(main.reverse(-2147483648), 0);
        Assert.assertEquals(main.reverse(-2147483648), 0);
        Assert.assertEquals(main.reverse(2147483647), 0);
    }
}