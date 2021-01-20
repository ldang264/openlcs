import org.junit.Assert;
import org.junit.Test;

public class Q00397mTest {

    @Test
    public void integerReplacement() {
        Q00397m ip = new Q00397m();
        Assert.assertEquals(0, ip.integerReplacement(1));
        Assert.assertEquals(1, ip.integerReplacement(2));
        Assert.assertEquals(2, ip.integerReplacement(3));
        Assert.assertEquals(2, ip.integerReplacement(4));
        Assert.assertEquals(3, ip.integerReplacement(5));
        Assert.assertEquals(3, ip.integerReplacement(6));
        Assert.assertEquals(4, ip.integerReplacement(7));
        Assert.assertEquals(3, ip.integerReplacement(8));
        Assert.assertEquals(4, ip.integerReplacement(9));
        Assert.assertEquals(4, ip.integerReplacement(10));
        Assert.assertEquals(5, ip.integerReplacement(11));
        Assert.assertEquals(4, ip.integerReplacement(12));
        Assert.assertEquals(5, ip.integerReplacement(13));
        Assert.assertEquals(5, ip.integerReplacement(14));
        Assert.assertEquals(5, ip.integerReplacement(15));
        Assert.assertEquals(4, ip.integerReplacement(16));
        Assert.assertEquals(5, ip.integerReplacement(17));
    }

    @Test
    public void integerReplacement1() {
        Q00397m ip = new Q00397m();
        Assert.assertEquals(32, ip.integerReplacement(Integer.MAX_VALUE));
    }

    @Test
    public void integerReplacement2() {
        Q00397m ip = new Q00397m();
        Assert.assertEquals(16, ip.integerReplacement(10000));
    }
}