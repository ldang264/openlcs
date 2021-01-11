package q00242s;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsAnagramTest {

    private IsAnagram isAnagram = new IsAnagram();

    @Test
    public void isAnagram() {
        Assert.assertTrue(isAnagram.isAnagram(null, null));
        Assert.assertTrue(isAnagram.isAnagram("b", "b"));
        Assert.assertTrue(isAnagram.isAnagram("acba", "baca"));
        Assert.assertTrue(isAnagram.isAnagram("", ""));
        Assert.assertFalse(isAnagram.isAnagram("", null));
        Assert.assertFalse(isAnagram.isAnagram("", "a"));
        Assert.assertFalse(isAnagram.isAnagram("ca", "c"));
        Assert.assertFalse(isAnagram.isAnagram("d", "b"));
    }
}