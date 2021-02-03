import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00461sTest {

    Q00461s q00461s = new Q00461s();

    @Test
    public void hammingDistance() {
        Assert.assertEquals(2, q00461s.hammingDistance(1, 4));
    }
}