import junit.framework.TestCase;
import org.junit.Assert;

public class Q00058sTest extends TestCase {

    private static Q00058s lolw = new Q00058s();

    public void testLengthOfLastWord1() {
        Assert.assertEquals(0, lolw.lengthOfLastWord(null));
        Assert.assertEquals(0, lolw.lengthOfLastWord(""));
        Assert.assertEquals(0, lolw.lengthOfLastWord(" "));
        Assert.assertEquals(1, lolw.lengthOfLastWord("a "));
        Assert.assertEquals(2, lolw.lengthOfLastWord("a cd"));
    }
}