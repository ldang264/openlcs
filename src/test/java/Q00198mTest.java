import org.junit.Assert;
import org.junit.Test;

public class Q00198mTest {

    Q00198m q00198m = new Q00198m();

    @Test
    public void rob() {
        Assert.assertEquals(4, q00198m.rob(new int[]{1, 2, 3, 1}));
        Assert.assertEquals(17, q00198m.rob(new int[]{2, 7, 9, 3, 1, 6}));
        Assert.assertEquals(12, q00198m.rob(new int[]{2, 7, 9, 3, 1}));
        Assert.assertEquals(20, q00198m.rob(new int[]{2, 7, 9, 3, 1, 4, 2, 5, 3}));
        Assert.assertEquals(1, q00198m.rob(new int[]{1}));
        Assert.assertEquals(2, q00198m.rob(new int[]{1, 2}));
        Assert.assertEquals(6, q00198m.rob(new int[]{3, 2, 2, 3}));
        Assert.assertEquals(0, q00198m.rob(new int[0]));
        Assert.assertEquals(7102, q00198m.rob(new int[]{226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191, 68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55, 122, 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77, 223, 188, 99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82, 35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124}));
    }
}