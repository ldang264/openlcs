import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00008_08mTest {

    M00008_08m m00008_08m = new M00008_08m();

    @Test
    public void permutation() {
        Assert.assertArrayEquals(m00008_08m.permutation("qqe"), new String[]{"eqq", "qeq", "qqe"});
    }
}