import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00655mTest {

    Q00655m q00655m = new Q00655m();

    @Test
    public void checkPossibility() {
        Assert.assertTrue(q00655m.checkPossibility(new int[]{4, 2, 3}));
        Assert.assertFalse(q00655m.checkPossibility(new int[]{3, 4, 2, 3}));
        Assert.assertFalse(q00655m.checkPossibility(new int[]{4, 2, 1}));
        Assert.assertTrue(q00655m.checkPossibility(new int[]{1, 2, 1}));
        Assert.assertTrue(q00655m.checkPossibility(new int[]{1, 2, 1, 2}));
    }
}