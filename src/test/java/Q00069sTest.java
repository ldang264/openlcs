import junit.framework.TestCase;
import org.junit.Assert;

public class Q00069sTest extends TestCase {

    private Q00069s mq = new Q00069s();

    public void testMySqrt1() {
        /*Assert.assertEquals(0, mq.mySqrt(0));
        Assert.assertEquals(1, mq.mySqrt(1));*/
        Assert.assertEquals(1, mq.mySqrt(2));
        Assert.assertEquals(1, mq.mySqrt(3));
        Assert.assertEquals(2, mq.mySqrt(4));
        Assert.assertEquals(2, mq.mySqrt(5));
        Assert.assertEquals(2, mq.mySqrt(6));
        Assert.assertEquals(2, mq.mySqrt(7));
        Assert.assertEquals(2, mq.mySqrt(8));
        Assert.assertEquals(3, mq.mySqrt(9));
    }

    public void testMySqrt() {
        Assert.assertEquals(46340, mq.mySqrt(2147483647));
    }
}