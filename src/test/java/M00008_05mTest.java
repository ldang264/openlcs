import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00008_05mTest {

    M00008_05m m00008_05m = new M00008_05m();

    @Test
    public void multiply() {
        Assert.assertEquals(m00008_05m.multiply(3, 5), 15);
        Assert.assertEquals(m00008_05m.multiply(3, 4), 12);
    }
}