import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00040mTest {

    Q00040m q00040m = new Q00040m();

    @Test
    public void combinationSum2() {
        Assert.assertEquals(q00040m.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).toString(), "[[2, 6], [1, 7], [1, 2, 5], [1, 1, 6]]");
        Assert.assertEquals(q00040m.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5).toString(), "[[5], [1, 2, 2]]");
    }
}