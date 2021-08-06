import org.junit.Assert;
import org.junit.Test;

public class Q00152mTest {

    Q00152m q00152m = new Q00152m();

    @Test
    public void maxProduct() {
        Assert.assertEquals(432, q00152m.maxProduct(new int[]{1, -2, 3, -4, -3, -4, -3}));
        Assert.assertEquals(6, q00152m.maxProduct(new int[]{2, 3, -2, 4}));
        Assert.assertEquals(24, q00152m.maxProduct(new int[]{-2, 3, -4}));
        Assert.assertEquals(0, q00152m.maxProduct(new int[]{0}));
        Assert.assertEquals(0, q00152m.maxProduct(new int[]{0, 0}));
        Assert.assertEquals(1, q00152m.maxProduct(new int[]{1}));
        Assert.assertEquals(1, q00152m.maxProduct(new int[]{1, 0}));
        Assert.assertEquals(1, q00152m.maxProduct(new int[]{0, 1}));
        Assert.assertEquals(-1, q00152m.maxProduct(new int[]{-1}));
        Assert.assertEquals(0, q00152m.maxProduct(new int[]{-1, 0}));
        Assert.assertEquals(0, q00152m.maxProduct(new int[]{0, -1}));
        Assert.assertEquals(24, q00152m.maxProduct(new int[]{-2, -1, 2, 3, -4}));
        Assert.assertEquals(12, q00152m.maxProduct(new int[]{2, 1, 2, 3, -4}));
        Assert.assertEquals(720, q00152m.maxProduct(new int[]{1, -1, 2, -3, 4, -5, 6}));
        Assert.assertEquals(24, q00152m.maxProduct(new int[]{-2, 1, 2, 3, 4}));
        Assert.assertEquals(12, q00152m.maxProduct(new int[]{1, 2, 0, 3, 4, 0}));
        Assert.assertEquals(0, q00152m.maxProduct(new int[]{-2, 0, -1}));
    }

    @Test
    public void maxProduct_DP() {
        Assert.assertEquals(12, q00152m.maxProduct_Ans(new int[]{1, 2, 0, 3, 4, 0}));
        Assert.assertEquals(12, q00152m.maxProduct_Ans(new int[]{2, 1, 2, 3, -4}));
        Assert.assertEquals(0, q00152m.maxProduct_Ans(new int[]{-1, 0}));
        Assert.assertEquals(-1, q00152m.maxProduct_Ans(new int[]{-1}));
        Assert.assertEquals(1, q00152m.maxProduct_Ans(new int[]{1, 0}));
        Assert.assertEquals(432, q00152m.maxProduct_Ans(new int[]{1, -2, 3, -4, -3, -4, -3}));
        Assert.assertEquals(0, q00152m.maxProduct_Ans(new int[]{0}));
        Assert.assertEquals(0, q00152m.maxProduct_Ans(new int[]{0, 0}));
        Assert.assertEquals(1, q00152m.maxProduct_Ans(new int[]{1}));
        Assert.assertEquals(1, q00152m.maxProduct_Ans(new int[]{0, 1}));
        Assert.assertEquals(0, q00152m.maxProduct_Ans(new int[]{0, -1}));
        Assert.assertEquals(24, q00152m.maxProduct_Ans(new int[]{-2, -1, 2, 3, -4}));
        Assert.assertEquals(720, q00152m.maxProduct_Ans(new int[]{1, -1, 2, -3, 4, -5, 6}));
        Assert.assertEquals(24, q00152m.maxProduct_Ans(new int[]{-2, 1, 2, 3, 4}));
        Assert.assertEquals(6, q00152m.maxProduct_Ans(new int[]{2, 3, -2, 4}));
        Assert.assertEquals(0, q00152m.maxProduct_Ans(new int[]{-2, 0, -1}));
    }
}