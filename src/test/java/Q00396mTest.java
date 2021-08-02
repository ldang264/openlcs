import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00396mTest {

    Q00396m q00396m = new Q00396m();

    @Test
    public void maxRotateFunction() {
        Assert.assertEquals(q00396m.maxRotateFunction(new int[]{4, 3, 2, 6}), 26);
    }
}