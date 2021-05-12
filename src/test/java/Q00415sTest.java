import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00415sTest {

    Q00415s q00415s = new Q00415s();

    @Test
    public void addStrings() {
        Assert.assertEquals(q00415s.addStrings("456", "77"), "533");
        Assert.assertEquals(q00415s.addStrings("11", "123"), "134");
        Assert.assertEquals(q00415s.addStrings("0", "0"), "0");
    }
}