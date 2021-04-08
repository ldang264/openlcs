import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00696sTest {

    Q00696s q00696s = new Q00696s();

    @Test
    public void countBinarySubstrings() {
        Assert.assertEquals(q00696s.countBinarySubstrings("00110011"), 6);
        Assert.assertEquals(q00696s.countBinarySubstrings("10101"), 4);
        Assert.assertEquals(q00696s.countBinarySubstrings("1"), 0);
        Assert.assertEquals(q00696s.countBinarySubstrings("10"), 1);
        Assert.assertEquals(q00696s.countBinarySubstrings("01"), 1);
    }
}