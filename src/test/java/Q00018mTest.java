import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00018mTest {

    Q00018m q00018m = new Q00018m();

    @Test
    public void fourSum() {
        Assert.assertEquals(q00018m.fourSum(new int[]{1,0,-1,0,-2,2}, 0).toString(), "[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]");
        Assert.assertEquals(q00018m.fourSum(new int[]{1,2,3,4}, 0).toString(), "[]");
        Assert.assertEquals(q00018m.fourSum(new int[]{2, 2, 2, 2, 2, 2}, 8).toString(), "[[2, 2, 2, 2]]");
    }
}