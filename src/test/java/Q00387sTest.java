import org.junit.Assert;
import org.junit.Test;

public class Q00387sTest {

    Q00387s fuc = new Q00387s();

    @Test
    public void firstUniqChar() {
        Assert.assertEquals(0, fuc.firstUniqChar("leetcode"));
        Assert.assertEquals(2, fuc.firstUniqChar("loveleetcode"));
    }
}