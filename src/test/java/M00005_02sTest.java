import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00005_02sTest {

    M00005_02s m00005_02s = new M00005_02s();

    @Test
    public void insertBits() {
        Assert.assertEquals(m00005_02s.insertBits(1024, 19, 2, 6), 1100);
        Assert.assertEquals(m00005_02s.insertBits(0, 31, 0, 4), 31);
    }
}