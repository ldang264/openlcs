import org.junit.Assert;
import org.junit.Test;

public class Q00055mTest {

    Q00055m q00055m = new Q00055m();

    @Test
    public void canJump() {
        Assert.assertTrue(q00055m.canJump(new int[]{1, 1, 2, 2, 0, 1, 1}));
        Assert.assertTrue(q00055m.canJump(new int[]{0}));
        Assert.assertFalse(q00055m.canJump(new int[]{0, 1}));
        Assert.assertTrue(q00055m.canJump(new int[]{3, 0}));
        Assert.assertTrue(q00055m.canJump(new int[]{3, 2, 3, 0, 0, 1}));
        Assert.assertTrue(q00055m.canJump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(q00055m.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}