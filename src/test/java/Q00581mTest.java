import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00581mTest {

    Q00581m q00581m = new Q00581m();

    @Test
    public void findUnsortedSubarray() {
        Assert.assertEquals(q00581m.findUnsortedSubarray(new int[]{5, 5, 3, 2, 4, 6, 2, 1, 2, 3, 4}), 11);
        Assert.assertEquals(q00581m.findUnsortedSubarray(new int[]{2, 6, 1, 8, 10, 9, 15}), 6);
        Assert.assertEquals(q00581m.findUnsortedSubarray(new int[]{5, 5, 3, 2, 4, 6, 2, 1, 5, 3, 4}), 11);
        Assert.assertEquals(q00581m.findUnsortedSubarray(new int[]{2, 6, 1, 8, 10, 9, 7}), 7);
        Assert.assertEquals(q00581m.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}), 5);
        Assert.assertEquals(q00581m.findUnsortedSubarray(new int[]{1, 2, 3, 4}), 0);
        Assert.assertEquals(q00581m.findUnsortedSubarray(new int[]{1}), 0);
    }
}