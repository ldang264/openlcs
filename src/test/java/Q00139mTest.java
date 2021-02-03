import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q00139mTest {

    Q00139m q00139m = new Q00139m();

    @Test
    public void wordBreak() {
        Assert.assertTrue(q00139m.wordBreak("aaaa", Arrays.asList("a")));
        Assert.assertFalse(q00139m.wordBreak("leetcode", Arrays.asList("leet", "codeb")));
        Assert.assertTrue(q00139m.wordBreak("leetcode", Arrays.asList("leet", "code")));
        Assert.assertTrue(q00139m.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        Assert.assertFalse(q00139m.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}