import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00003mTest {
    
    Q00003m lols = new Q00003m();
    
    @Test
    public void lengthOfLongestSubstring() {
        Assert.assertEquals(2, lols.lengthOfLongestSubstring("abba"));
        Assert.assertEquals(3, lols.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(3, lols.lengthOfLongestSubstring("abac"));
        Assert.assertEquals(1, lols.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, lols.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(2, lols.lengthOfLongestSubstring("ab"));
        Assert.assertEquals(3, lols.lengthOfLongestSubstring("abcac"));
    }
}