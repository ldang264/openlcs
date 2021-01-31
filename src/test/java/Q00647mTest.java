import junit.framework.TestCase;
import org.junit.Assert;

public class Q00647mTest extends TestCase {

    Q00647m q00647m = new Q00647m();

    public void testCountSubstrings() {
        Assert.assertEquals(3, q00647m.countSubstrings("abc"));
        Assert.assertEquals(6, q00647m.countSubstrings("aaa"));
    }
}