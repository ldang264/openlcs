package q00058s;

import junit.framework.TestCase;
import org.junit.Assert;

public class LengthOfLastWordTest extends TestCase {

    private static LengthOfLastWord lolw = new LengthOfLastWord();

    public void testLengthOfLastWord1() {
        Assert.assertEquals(0, lolw.lengthOfLastWord(null));
        Assert.assertEquals(0, lolw.lengthOfLastWord(""));
        Assert.assertEquals(0, lolw.lengthOfLastWord(" "));
        Assert.assertEquals(1, lolw.lengthOfLastWord("a "));
        Assert.assertEquals(2, lolw.lengthOfLastWord("a cd"));
    }
}