import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00557sTest {

    Q00557s q00557s = new Q00557s();

    @Test
    public void reverseWords() {
        Assert.assertEquals(q00557s.reverseWords("Let's take LeetCode contest"), "s'teL ekat edoCteeL tsetnoc");
        Assert.assertEquals(q00557s.reverseWords(" 12"), " 21");
        Assert.assertEquals(q00557s.reverseWords(" 12 "), " 21 ");
        Assert.assertEquals(q00557s.reverseWords("12 "), "21 ");
        Assert.assertEquals(q00557s.reverseWords("12"), "21");
        Assert.assertEquals(q00557s.reverseWords("12 34"), "21 43");
        Assert.assertEquals(q00557s.reverseWords(" "), " ");
        Assert.assertEquals(q00557s.reverseWords(""), "");
        Assert.assertNull(q00557s.reverseWords(null));
    }
}