import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00001_01sTest {

    M00001_01s m00001_01s = new M00001_01s();

    @Test
    public void isUnique() {
        Assert.assertFalse(m00001_01s.isUnique("leetcode"));
        Assert.assertTrue(m00001_01s.isUnique("abc"));
        Assert.assertTrue(m00001_01s.isUnique(""));
    }
}