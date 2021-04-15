import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00201mTest {

    Q00201m q00201m = new Q00201m();

    @Test
    public void rangeBitwiseAnd() {
        Assert.assertEquals(q00201m.rangeBitwiseAnd(6, 7), 6);
        Assert.assertEquals(q00201m.rangeBitwiseAnd(1, Integer.MAX_VALUE), 0);
    }
}