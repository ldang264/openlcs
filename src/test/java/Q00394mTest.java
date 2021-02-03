import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00394mTest {

    Q00394m q00394m = new Q00394m();

    @Test
    public void decodeString() {
        Assert.assertEquals("bbbbbbbb", q00394m.decodeString("2[2[2[b]]]"));
        Assert.assertEquals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef", q00394m.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        Assert.assertEquals("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode", q00394m.decodeString("100[leetcode]"));
        Assert.assertEquals("aaabcbc", q00394m.decodeString("3[a]2[bc]"));
        Assert.assertEquals("accaccacc", q00394m.decodeString("3[a2[c]]"));
        Assert.assertEquals("abcabccdcdcdef", q00394m.decodeString("2[abc]3[cd]ef"));
        Assert.assertEquals("abccdcdcdxyz", q00394m.decodeString("abc3[cd]xyz"));
    }
}