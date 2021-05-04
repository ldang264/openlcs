import org.junit.Assert;
import org.junit.Test;

public class Q00516m_Test {

    Q00516m q00516m = new Q00516m();

    @Test
    public void longestPalindromeSubseq() {
        Assert.assertEquals(q00516m.longestPalindromeSubseq("aabaa"), 5);
        Assert.assertEquals(q00516m.longestPalindromeSubseq("bbbab"), 4);
        Assert.assertEquals(q00516m.longestPalindromeSubseq("cbbd"), 2);
    }
}