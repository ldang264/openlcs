import org.junit.Assert;
import org.junit.Test;

public class Q00009sTest {

    Q00009s q00009s = new Q00009s();

    @Test
    public void isPalindrome() {
        Assert.assertTrue(q00009s.isPalindrome(11));
        Assert.assertTrue(q00009s.isPalindrome(121));
        Assert.assertTrue(q00009s.isPalindrome(1001));
        Assert.assertFalse(q00009s.isPalindrome(-121));
        Assert.assertFalse(q00009s.isPalindrome(10));
    }
}