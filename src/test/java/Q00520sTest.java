import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00520sTest {

    Q00520s q00520s = new Q00520s();

    @Test
    public void detectCapitalUse() {
        Assert.assertTrue(q00520s.detectCapitalUse("ABC"));
        Assert.assertTrue(q00520s.detectCapitalUse("Abc"));
        Assert.assertTrue(q00520s.detectCapitalUse("abc"));
        Assert.assertFalse(q00520s.detectCapitalUse("aBC"));
        Assert.assertFalse(q00520s.detectCapitalUse("aBc"));
        Assert.assertFalse(q00520s.detectCapitalUse("ABc"));
        Assert.assertFalse(q00520s.detectCapitalUse("AbC"));
    }
}