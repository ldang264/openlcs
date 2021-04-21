import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00077mTest {

    Q00077m q00077m = new Q00077m();

    @Test
    public void combine() {
        Assert.assertEquals(q00077m.combine(4, 2).toString(), "[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]");
        Assert.assertEquals(q00077m.combine(1, 1).toString(), "[[1]]");
        Assert.assertEquals(q00077m.combine(2, 1).toString(), "[[1], [2]]");
        Assert.assertEquals(q00077m.combine(2, 2).toString(), "[[1, 2]]");
    }
}