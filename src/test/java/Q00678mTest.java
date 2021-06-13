import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00678mTest {

    Q00678m q00678m = new Q00678m();

    @Test
    public void checkValidString() {
        Assert.assertTrue(q00678m.checkValidString("*)"));
        Assert.assertTrue(q00678m.checkValidString("()"));
        Assert.assertTrue(q00678m.checkValidString("(*)"));
        Assert.assertTrue(q00678m.checkValidString("(*))"));
        Assert.assertFalse(q00678m.checkValidString("(()"));
    }
}