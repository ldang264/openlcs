import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00171sTest {

    Q00171s q00171s = new Q00171s();

    @Test
    public void titleToNumber() {
        Assert.assertEquals(q00171s.titleToNumber("A"), 1);
        Assert.assertEquals(q00171s.titleToNumber("AB"), 28);
        Assert.assertEquals(q00171s.titleToNumber("ZY"), 701);
        Assert.assertEquals(q00171s.titleToNumber("FXSHRXW"), Integer.MAX_VALUE);
    }
}