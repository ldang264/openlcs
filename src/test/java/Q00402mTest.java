import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00402mTest {

    Q00402m q00402m = new Q00402m();

    @Test
    public void removeKdigits() {
        Assert.assertEquals(q00402m.removeKdigits("10200", 1), "200");
        Assert.assertEquals(q00402m.removeKdigits("1230", 3), "0");
        Assert.assertEquals(q00402m.removeKdigits("1432219", 3), "1219");
        Assert.assertEquals(q00402m.removeKdigits("1173", 2), "11");
        Assert.assertEquals(q00402m.removeKdigits("10", 2), "0");
    }
}