import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00216mTest {

    Q00216m q00216m = new Q00216m();

    @Test
    public void combinationSum3() {
        Assert.assertEquals(q00216m.combinationSum3(3, 7).toString(), "[[1, 2, 4]]");
        Assert.assertEquals(q00216m.combinationSum3(3, 9).toString(), "[[2, 3, 4], [1, 3, 5], [1, 2, 6]]");
        Assert.assertEquals(q00216m.combinationSum3(9, 45).toString(), "[[1, 2, 3, 4, 5, 6, 7, 8, 9]]");
    }
}