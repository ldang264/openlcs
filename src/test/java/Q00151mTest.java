import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00151mTest {

    Q00151m q00151m = new Q00151m();

    @Test
    public void reverseWords() {
        Assert.assertEquals(q00151m.reverseWords("  hello world!  "), "world! hello");
        Assert.assertEquals(q00151m.reverseWords("a"), "a");
        Assert.assertEquals(q00151m.reverseWords(" "), "");
        Assert.assertEquals(q00151m.reverseWords("  "), "");
        Assert.assertEquals(q00151m.reverseWords("the sky is blue"), "blue is sky the");
        Assert.assertEquals(q00151m.reverseWords("a good   example"), "example good a");
    }
}