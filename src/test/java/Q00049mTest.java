import org.junit.Assert;
import org.junit.Test;

public class Q00049mTest {

    Q00049m q00049m = new Q00049m();

    @Test
    public void groupAnagrams() {
        Assert.assertEquals("[[bdddddddddd], [bbbbbbbbbbc]]", q00049m.groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"}).toString());
        Assert.assertEquals("[[aacc], [bd]]", q00049m.groupAnagrams(new String[]{"bd", "aacc"}).toString());
    }
}