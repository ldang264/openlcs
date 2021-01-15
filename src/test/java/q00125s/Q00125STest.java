package q00125s;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00125STest {

    Q00125S q00125s = new Q00125S();

    @Test
    public void isPalindrome() {
        Assert.assertFalse(q00125s.isPalindrome("0P"));
        Assert.assertTrue(q00125s.isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertTrue(q00125s.isPalindrome(null));
        Assert.assertTrue(q00125s.isPalindrome(""));
        Assert.assertTrue(q00125s.isPalindrome("a"));
        Assert.assertTrue(q00125s.isPalindrome(","));
        Assert.assertTrue(q00125s.isPalindrome("a,"));
        Assert.assertFalse(q00125s.isPalindrome("race a car"));
    }
}