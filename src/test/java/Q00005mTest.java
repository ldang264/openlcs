import org.junit.Assert;
import org.junit.Test;

public class Q00005mTest {

    Q00005m q00005m = new Q00005m();

    @Test
    public void longestPalindrome() {
        Assert.assertEquals("aaaa", q00005m.longestPalindrome("aaaa"));
        Assert.assertEquals("bb", q00005m.longestPalindrome("bb"));
        Assert.assertEquals("bbb", q00005m.longestPalindrome("bbb"));
        Assert.assertEquals("bab", q00005m.longestPalindrome("babad"));
        Assert.assertEquals("bb", q00005m.longestPalindrome("cbbd"));
        Assert.assertEquals("a", q00005m.longestPalindrome("a"));
        Assert.assertEquals("a", q00005m.longestPalindrome("ac"));
    }
}