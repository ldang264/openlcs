import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00347mTest {

    Q00347m q00347m = new Q00347m();

    @Test
    public void topKFrequent() {
        Assert.assertArrayEquals(q00347m.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2), new int[]{-1, 2});
        Assert.assertArrayEquals(q00347m.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2), new int[]{1, 2});
        Assert.assertArrayEquals(q00347m.topKFrequent(new int[]{1}, 1), new int[]{1});
    }
}