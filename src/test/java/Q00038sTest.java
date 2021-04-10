import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00038sTest {

    Q00038s q00038s = new Q00038s();

    @Test
    public void countAndSay() {
        Assert.assertEquals(q00038s.countAndSay(1), "1");
        Assert.assertEquals(q00038s.countAndSay(2), "11");
        Assert.assertEquals(q00038s.countAndSay(3), "21");
        Assert.assertEquals(q00038s.countAndSay(4), "1211");
        Assert.assertEquals(q00038s.countAndSay(5), "111221");
        Assert.assertEquals(q00038s.countAndSay(6), "312211");
    }
}