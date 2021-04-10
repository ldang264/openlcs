import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00205sTest {

    Q00205s q00205s = new Q00205s();

    @Test
    public void isIsomorphic() {
        Assert.assertTrue(q00205s.isIsomorphic("paper", "title"));
        Assert.assertTrue(q00205s.isIsomorphic("egg", "add"));
        Assert.assertFalse(q00205s.isIsomorphic("foo", "bar"));
        Assert.assertFalse(q00205s.isIsomorphic("bbbaaaba", "aaabbbba"));
        Assert.assertFalse(q00205s.isIsomorphic("badc", "baba"));
    }
}