import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00017_09mTest {

    M00017_09m m00017_09m = new M00017_09m();

    @Test
    public void getKthMagicNumber() {
        Assert.assertEquals(m00017_09m.getKthMagicNumber(5), 9);
        Assert.assertEquals(m00017_09m.getKthMagicNumber(8), 25);
    }
}