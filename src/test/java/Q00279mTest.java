import org.junit.Assert;
import org.junit.Test;

public class Q00279mTest {

    Q00279m q00279m = new Q00279m();

    @Test
    public void numSquares() {
        Assert.assertEquals(2, q00279m.numSquares(5));
        Assert.assertEquals(1, q00279m.numSquares(4));
        Assert.assertEquals(1, q00279m.numSquares(1));
        Assert.assertEquals(2, q00279m.numSquares(2));
        Assert.assertEquals(3, q00279m.numSquares(3));
        Assert.assertEquals(3, q00279m.numSquares(6));
        Assert.assertEquals(4, q00279m.numSquares(7));
        Assert.assertEquals(2, q00279m.numSquares(8));
        Assert.assertEquals(1, q00279m.numSquares(9));
        Assert.assertEquals(2, q00279m.numSquares(10));
        Assert.assertEquals(3, q00279m.numSquares(11));
        Assert.assertEquals(3, q00279m.numSquares(12));
        Assert.assertEquals(2, q00279m.numSquares(13));
        Assert.assertEquals(3, q00279m.numSquares(48));
        Assert.assertEquals(2, q00279m.numSquares(153));
        Assert.assertEquals(1, q00279m.numSquares(100));
        Assert.assertEquals(4, q00279m.numSquares(4567));
        Assert.assertEquals(2, q00279m.numSquares(4321));
        Assert.assertEquals(2, q00279m.numSquares(976));
    }
}