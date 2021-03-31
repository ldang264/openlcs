import org.junit.Assert;
import org.junit.Test;
import todo.Q00918m_Todo;

public class Q00918mTest {

    Q00918m_Todo q00918m = new Q00918m_Todo();

    @Test
    public void maxSubarraySumCircular() {
        Assert.assertEquals(q00918m.maxSubarraySumCircular(new int[]{1, -2, 3, -2}), 3);
        Assert.assertEquals(q00918m.maxSubarraySumCircular(new int[]{5, -3, 5}), 10);
        Assert.assertEquals(q00918m.maxSubarraySumCircular(new int[]{3, -1, 2, -1}), 4);
        Assert.assertEquals(q00918m.maxSubarraySumCircular(new int[]{3, -2, 2, -3}), 3);
        Assert.assertEquals(q00918m.maxSubarraySumCircular(new int[]{-2, -3, -1}), -1);
        Assert.assertEquals(q00918m.maxSubarraySumCircular(new int[]{-2}), -2);
        Assert.assertEquals(q00918m.maxSubarraySumCircular(new int[]{1}), 1);
    }
}