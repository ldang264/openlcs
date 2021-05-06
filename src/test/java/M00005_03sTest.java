import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00005_03sTest {

    M00005_03s m00005_03s = new M00005_03s();

    @Test
    public void reverseBits() {
        Assert.assertEquals(m00005_03s.reverseBits(Integer.MIN_VALUE), 2);
        Assert.assertEquals(m00005_03s.reverseBits(-1), 32);
        Assert.assertEquals(m00005_03s.reverseBits(Integer.parseInt("11", 2)), 3);
        Assert.assertEquals(m00005_03s.reverseBits(0), 1);
        Assert.assertEquals(m00005_03s.reverseBits(7), 4);
        Assert.assertEquals(m00005_03s.reverseBits(Integer.parseInt("1011110111111011", 2)), 11);
        Assert.assertEquals(m00005_03s.reverseBits(1775), 8);
        Assert.assertEquals(m00005_03s.reverseBits(Integer.MAX_VALUE), 32);
    }
}