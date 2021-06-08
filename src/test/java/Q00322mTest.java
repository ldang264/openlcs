import org.junit.Assert;
import org.junit.Test;

public class Q00322mTest {

    Q00322m q00322m = new Q00322m();

    @Test
    public void coinChange() {
        Assert.assertEquals(35, q00322m.coinChange(new int[]{357, 239, 73, 52}, 9832));
        Assert.assertEquals(25, q00322m.coinChange(new int[]{3, 7, 405, 436}, 8839));
        Assert.assertEquals(2, q00322m.coinChange(new int[]{1, Integer.MAX_VALUE}, 2));
        Assert.assertEquals(23, q00322m.coinChange(new int[]{243, 291, 335, 209, 177, 345, 114, 91, 313, 331}, 7367));
        Assert.assertEquals(22, q00322m.coinChange(new int[]{288, 160, 10, 249, 40, 77, 314, 429}, 9208));
        Assert.assertEquals(20, q00322m.coinChange(new int[]{186, 419, 83, 408}, 6249));
        Assert.assertEquals(1, q00322m.coinChange(new int[]{1, 2, 5}, 1));
        Assert.assertEquals(1, q00322m.coinChange(new int[]{1, 2, 5}, 2));
        Assert.assertEquals(2, q00322m.coinChange(new int[]{1, 2, 5}, 3));
        Assert.assertEquals(2, q00322m.coinChange(new int[]{1, 2, 5}, 4));
        Assert.assertEquals(1, q00322m.coinChange(new int[]{1, 2, 5}, 5));
        Assert.assertEquals(2, q00322m.coinChange(new int[]{1, 2, 5}, 6));
        Assert.assertEquals(2, q00322m.coinChange(new int[]{1, 2, 5}, 7));
        Assert.assertEquals(3, q00322m.coinChange(new int[]{1, 2, 5}, 8));
        Assert.assertEquals(3, q00322m.coinChange(new int[]{1, 2, 5}, 9));
        Assert.assertEquals(2, q00322m.coinChange(new int[]{1, 2, 5}, 10));
        Assert.assertEquals(3, q00322m.coinChange(new int[]{1, 2, 5}, 11));
        Assert.assertEquals(3, q00322m.coinChange(new int[]{1, 2, 5}, 12));
        Assert.assertEquals(4, q00322m.coinChange(new int[]{1, 2, 5}, 13));
        Assert.assertEquals(4, q00322m.coinChange(new int[]{1, 2, 5}, 14));
        Assert.assertEquals(3, q00322m.coinChange(new int[]{1, 2, 5}, 15));
        Assert.assertEquals(1, q00322m.coinChange(new int[]{1}, 1));
        Assert.assertEquals(-1, q00322m.coinChange(new int[]{2}, 3));
        Assert.assertEquals(0, q00322m.coinChange(new int[]{1}, 0));
        Assert.assertEquals(2, q00322m.coinChange(new int[]{1}, 2));
    }

}