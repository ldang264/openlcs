import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01328mTest {

    Q01328m q01328m = new Q01328m();

    @Test
    public void breakPalindrome() {
        Assert.assertEquals(q01328m.breakPalindrome("a"), "");
        Assert.assertEquals(q01328m.breakPalindrome("acca"), "aaca");
        Assert.assertEquals(q01328m.breakPalindrome("acaaca"), "aaaaca");
        Assert.assertEquals(q01328m.breakPalindrome("aa"), "ab");
        Assert.assertEquals(q01328m.breakPalindrome("bb"), "ab");
        Assert.assertEquals(q01328m.breakPalindrome("aba"), "abb");
        Assert.assertEquals(q01328m.breakPalindrome("aca"), "acb");
        Assert.assertEquals(q01328m.breakPalindrome("baab"), "aaab");
        Assert.assertEquals(q01328m.breakPalindrome("abccba"), "aaccba");
    }
}