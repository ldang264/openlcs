import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01539sTest {

    Q01539s q01539s = new Q01539s();

    @Test
    public void findKthPositive() {
        Assert.assertEquals(q01539s.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5), 9);
        Assert.assertEquals(q01539s.findKthPositive(new int[]{2, 4}, 3), 5);
        Assert.assertEquals(q01539s.findKthPositive(new int[]{2, 4}, 2), 3);
        Assert.assertEquals(q01539s.findKthPositive(new int[]{2, 4}, 1), 1);
        Assert.assertEquals(q01539s.findKthPositive(new int[]{1, 2, 3, 4}, 2), 6);
    }
}