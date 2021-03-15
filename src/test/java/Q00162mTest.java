import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00162mTest {

    Q00162m q00162m = new Q00162m();

    @Test
    public void findPeakElement() {
        Assert.assertEquals(q00162m.findPeakElement(new int[]{1}), 0);
        Assert.assertEquals(q00162m.findPeakElement(new int[]{1, 2}), 1);
        Assert.assertEquals(q00162m.findPeakElement(new int[]{2, 1}), 0);
        Assert.assertEquals(q00162m.findPeakElement(new int[]{1, 2, 1}), 1);
        Assert.assertEquals(q00162m.findPeakElement(new int[]{1, 2, 3, 1}), 2);
        Assert.assertEquals(q00162m.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}), 5);
    }
}