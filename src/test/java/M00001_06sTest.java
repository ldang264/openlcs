import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00001_06sTest {

    M00001_06s m00001_06s = new M00001_06s();

    @Test
    public void compressString() {
        Assert.assertEquals(m00001_06s.compressString("aaaab"), "a4b1");
        Assert.assertEquals(m00001_06s.compressString("aaaabb"), "a4b2");
        Assert.assertEquals(m00001_06s.compressString("aabcccccaaa"), "a2b1c5a3");
        Assert.assertEquals(m00001_06s.compressString("abbccd"), "abbccd");
    }
}