import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00097mTest {

    Q00097m q00097m = new Q00097m();

    @Test
    public void isInterleave() {
        Assert.assertTrue(q00097m.isInterleave("", "", ""));
        Assert.assertTrue(q00097m.isInterleave("", "a", "a"));
        Assert.assertTrue(q00097m.isInterleave("ab", "", "ab"));
        Assert.assertTrue(q00097m.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        Assert.assertTrue(q00097m.isInterleave("aabd", "abdc", "aabdabcd"));
        Assert.assertFalse(q00097m.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        Assert.assertFalse(q00097m.isInterleave("aabd", "abdc", "aabdbadc"));
    }
}