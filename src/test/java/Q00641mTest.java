import org.junit.Assert;
import org.junit.Test;

public class Q00641mTest {

    @Test
    public void test() {
        Q00641m q00641m = new Q00641m(8);
        Assert.assertTrue(q00641m.insertFront(5));
        Assert.assertEquals(q00641m.getFront(), 5);
        Assert.assertFalse(q00641m.isEmpty());
    }
}