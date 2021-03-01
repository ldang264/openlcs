import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00697sTest {

    Q00697s q00697s = new Q00697s();

    @Test
    public void findShortestSubArray() {
        Assert.assertEquals(2, q00697s.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        Assert.assertEquals(6, q00697s.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        Assert.assertEquals(1, q00697s.findShortestSubArray(new int[]{1}));
    }
}