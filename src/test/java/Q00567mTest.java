import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00567mTest {

    Q00567m q00567m = new Q00567m();

    @Test
    public void checkInclusion() {
        Assert.assertFalse(q00567m.checkInclusion("rmqqh", "nrsqrqhrymf"));
        Assert.assertTrue(q00567m.checkInclusion("abc", "eiabdcbebac"));
        Assert.assertTrue(q00567m.checkInclusion("aaaa", "efaaacihaaaa"));
        Assert.assertTrue(q00567m.checkInclusion("ab", "eidbaooo"));
        Assert.assertFalse(q00567m.checkInclusion("ab", "eidboaoo"));
    }
}