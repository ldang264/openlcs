import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00008_01sTest {

    M00008_01s m00008_01s = new M00008_01s();

    @Test
    public void waysToStep() {
        Assert.assertEquals(m00008_01s.waysToStep(3), 4);
        Assert.assertEquals(m00008_01s.waysToStep(5), 13);
        Assert.assertEquals(m00008_01s.waysToStep(35), 132436845);
    }
}