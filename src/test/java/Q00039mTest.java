import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00039mTest {

    Q00039m q00039m = new Q00039m();

    @Test
    public void combinationSum() {
        Assert.assertEquals("[[7], [2, 2, 3]]", q00039m.combinationSum(new int[]{2,3,6,7}, 7).toString());
        Assert.assertEquals("[[3, 5], [2, 3, 3], [2, 2, 2, 2]]", q00039m.combinationSum(new int[]{2,3,5}, 8).toString());
    }
}