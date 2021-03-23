import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00048mTest {

    J00048m j00048m = new J00048m();

    @Test
    public void lengthOfLongestSubstring() {
        Assert.assertEquals(j00048m.lengthOfLongestSubstring("tmmzuxt"), 5);
        Assert.assertEquals(j00048m.lengthOfLongestSubstring("bacabcd"), 4);
        Assert.assertEquals(j00048m.lengthOfLongestSubstring("bacabc"), 3);
        Assert.assertEquals(j00048m.lengthOfLongestSubstring("abcabcbb"), 3);
        Assert.assertEquals(j00048m.lengthOfLongestSubstring("bbbbb"), 1);
        Assert.assertEquals(j00048m.lengthOfLongestSubstring("pwwkew"), 3);
    }
}