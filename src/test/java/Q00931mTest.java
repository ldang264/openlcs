import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00931mTest {

    Q00931m q00931m = new Q00931m();

    @Test
    public void minFallingPathSum() {
        Assert.assertEquals(q00931m.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}), 13);
        Assert.assertEquals(q00931m.minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}), -59);
        Assert.assertEquals(q00931m.minFallingPathSum(new int[][]{{-48}}), -48);
    }
}