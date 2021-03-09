import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00215mTest {

    Q00215m q00215m = new Q00215m();

    @Test
    public void findKthLargest() {
        Assert.assertEquals(q00215m.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2), 5);
        Assert.assertEquals(q00215m.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4), 4);
    }
}