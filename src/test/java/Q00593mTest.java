import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00593mTest {

    Q00593m q00593m = new Q00593m();

    @Test
    public void validSquare() {
        Assert.assertTrue(q00593m.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
    }
}