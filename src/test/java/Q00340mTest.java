import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00340mTest {

    Q00340m q00340m = new Q00340m();

    @Test
    public void lengthOfLongestSubstringKDistinct() {
        Assert.assertEquals(4, q00340m.lengthOfLongestSubstringKDistinct("abaccc", 2));
        Assert.assertEquals(3, q00340m.lengthOfLongestSubstringKDistinct("eceba", 2));
        Assert.assertEquals(2, q00340m.lengthOfLongestSubstringKDistinct("aa", 1));
    }
}