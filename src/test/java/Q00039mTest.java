import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00039mTest {

    Q00039m q00039m = new Q00039m();

    @Test
    public void combinationSum() {
        Assert.assertEquals(q00039m.combinationSum(new int[]{2, 3, 6, 7}, 7).toString(), "[[2, 2, 3], [7]]");
        Assert.assertEquals(q00039m.combinationSum(new int[]{2, 3, 5}, 8).toString(), "[[2, 3, 3], [2, 2, 2, 2], [3, 5]]");
    }
}