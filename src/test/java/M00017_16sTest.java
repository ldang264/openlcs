import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00017_16sTest {
    M00017_16s m00017_16s = new M00017_16s();

    @Test
    public void massage() {
        Assert.assertEquals(m00017_16s.massage(new int[]{2, 7, 9, 3, 1}), 12);
        Assert.assertEquals(m00017_16s.massage(new int[]{1, 2, 3, 1}), 4);
        Assert.assertEquals(m00017_16s.massage(new int[]{2, 7, 9, 3, 1}), 12);
    }
}