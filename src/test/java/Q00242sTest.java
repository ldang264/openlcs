import org.junit.Assert;
import org.junit.Test;

public class Q00242sTest {

    private Q00242s q00242s = new Q00242s();

    @Test
    public void isAnagram() {
        Assert.assertTrue(q00242s.isAnagram(null, null));
        Assert.assertTrue(q00242s.isAnagram("b", "b"));
        Assert.assertTrue(q00242s.isAnagram("acba", "baca"));
        Assert.assertTrue(q00242s.isAnagram("", ""));
        Assert.assertFalse(q00242s.isAnagram("", null));
        Assert.assertFalse(q00242s.isAnagram("", "a"));
        Assert.assertFalse(q00242s.isAnagram("ca", "c"));
        Assert.assertFalse(q00242s.isAnagram("d", "b"));
    }
}