import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01358mTest {

    Q01358m q01358m = new Q01358m();

    @Test
    public void numberOfSubstrings() {
        Assert.assertEquals(q01358m.numberOfSubstrings("acbbcac"), 11);
        Assert.assertEquals(q01358m.numberOfSubstrings("abcabc"), 10);
        Assert.assertEquals(q01358m.numberOfSubstrings("ababbbc"), 3);
        Assert.assertEquals(q01358m.numberOfSubstrings("aaacb"), 3);
        Assert.assertEquals(q01358m.numberOfSubstrings("abc"), 1);
        Assert.assertEquals(q01358m.numberOfSubstrings("aaa"), 0);
    }

    @Test
    public void numberOfSubstringsAns() {
        Assert.assertEquals(q01358m.numberOfSubstringsAns("acbbcac"), 11);
        Assert.assertEquals(q01358m.numberOfSubstringsAns("abcabc"), 10);
        Assert.assertEquals(q01358m.numberOfSubstringsAns("ababbbc"), 3);
        Assert.assertEquals(q01358m.numberOfSubstringsAns("aaacb"), 3);
        Assert.assertEquals(q01358m.numberOfSubstringsAns("abc"), 1);
        Assert.assertEquals(q01358m.numberOfSubstringsAns("aaa"), 0);
    }
}