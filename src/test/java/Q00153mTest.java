import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00153mTest {

    Q00153m q00153m = new Q00153m();

    @Test
    public void findMin() {
        Assert.assertEquals(q00153m.findMin(new int[]{1}), 1);
        Assert.assertEquals(q00153m.findMin(new int[]{1, 2}), 1);
        Assert.assertEquals(q00153m.findMin(new int[]{1, 2, 3}), 1);
        Assert.assertEquals(q00153m.findMin(new int[]{1, 2, 3, 4}), 1);
        Assert.assertEquals(q00153m.findMin(new int[]{2, 1}), 1);
        Assert.assertEquals(q00153m.findMin(new int[]{2, 3, 1}), 1);
        Assert.assertEquals(q00153m.findMin(new int[]{3, 1, 2}), 1);
        Assert.assertEquals(q00153m.findMin(new int[]{2, 3, 4, 1}), 1);
        Assert.assertEquals(q00153m.findMin(new int[]{3, 4, 1, 2}), 1);
        Assert.assertEquals(q00153m.findMin(new int[]{4, 1, 2, 3}), 1);
        Assert.assertEquals(q00153m.findMin(new int[]{3,4,5,1,2}), 1);
        Assert.assertEquals(q00153m.findMin(new int[]{4,5,6,7,0,1,2}), 0);
    }
}