import org.junit.Assert;
import org.junit.Test;

public class Q00202sTest {

    Q00202s q00202s = new Q00202s();

    @Test
    public void isHappy() {
        Assert.assertTrue(q00202s.isHappy(1));
        Assert.assertFalse(q00202s.isHappy(2));
        Assert.assertFalse(q00202s.isHappy(3));
        Assert.assertFalse(q00202s.isHappy(4));
        Assert.assertFalse(q00202s.isHappy(5));
        Assert.assertFalse(q00202s.isHappy(6));
        Assert.assertTrue(q00202s.isHappy(7));
        Assert.assertFalse(q00202s.isHappy(8));
        Assert.assertFalse(q00202s.isHappy(9));
        Assert.assertTrue(q00202s.isHappy(10));
        Assert.assertTrue(q00202s.isHappy(19));
    }
}