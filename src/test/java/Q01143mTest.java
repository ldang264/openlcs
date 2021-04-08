import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01143mTest {

    Q01143m q01143m = new Q01143m();

    @Test
    public void longestCommonSubsequence() {
        Assert.assertEquals(q01143m.longestCommonSubsequence("ezupkr", "ubmrapg"), 2);
        Assert.assertEquals(q01143m.longestCommonSubsequence("abcde", "ace"), 3);
        Assert.assertEquals(q01143m.longestCommonSubsequence("bsbininm", "jmjkbkjkv"), 1);
        Assert.assertEquals(q01143m.longestCommonSubsequence("abc", "abc"), 3);
        Assert.assertEquals(q01143m.longestCommonSubsequence("abc", "def"), 0);
        Assert.assertEquals(q01143m.longestCommonSubsequence("abcde", "dc"), 1);
        Assert.assertEquals(q01143m.longestCommonSubsequence("abcde", "be"), 2);
    }
}