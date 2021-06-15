import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00868sTest {

    Q00868s q00868s = new Q00868s();

    @Test
    public void binaryGap() {
        Assert.assertEquals(q00868s.binaryGap(5), 2);
        Assert.assertEquals(q00868s.binaryGap(22), 2);
        Assert.assertEquals(q00868s.binaryGap(6), 1);
        Assert.assertEquals(q00868s.binaryGap(8), 0);
        Assert.assertEquals(q00868s.binaryGap(1), 0);
    }
}