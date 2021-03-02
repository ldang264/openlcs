import org.junit.Assert;
import org.junit.Test;

public class Q00084hTest {

    Q00084h_Ans q00084h = new Q00084h_Ans();

    @Test
    public void largestRectangleArea() {
        Assert.assertEquals(10, q00084h.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        Assert.assertEquals(6, q00084h.largestRectangleArea(new int[]{1, 2, 3, 2, 1}));
        Assert.assertEquals(1, q00084h.largestRectangleArea(new int[]{1}));
        Assert.assertEquals(2, q00084h.largestRectangleArea(new int[]{2, 1}));
        Assert.assertEquals(12, q00084h.largestRectangleArea(new int[]{2, 3, 4, 5, 6}));
    }
}