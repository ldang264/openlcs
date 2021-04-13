import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01047sTest {

    Q01047s q01047s = new Q01047s();

    @Test
    public void removeDuplicates() {
        Assert.assertEquals(q01047s.removeDuplicates("abbaca"), "ca");
        Assert.assertEquals(q01047s.removeDuplicates("aa"), "");
        Assert.assertEquals(q01047s.removeDuplicates("aaa"), "a");
        Assert.assertEquals(q01047s.removeDuplicates("aaaa"), "");
        Assert.assertEquals(q01047s.removeDuplicates("aaaaa"), "a");
    }
}