import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00541sTest {

    Q00541s q00541s = new Q00541s();

    @Test
    public void reverseStr() {
        Assert.assertEquals(q00541s.reverseStr("abcdefg", 2), "bacdfeg");
        Assert.assertEquals(q00541s.reverseStr("abcdefgh", 3), "cbadefhg");
        Assert.assertEquals(q00541s.reverseStr("abcdefghi", 3), "cbadefihg");
    }
}