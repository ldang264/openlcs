import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class M00005_04mTest {

    M00005_04m m00005_04m = new M00005_04m();

    @Test
    public void findClosedNumbers() {
        Assert.assertArrayEquals(m00005_04m.findClosedNumbers(14), new int[]{19,13});
        Assert.assertArrayEquals(m00005_04m.findClosedNumbers(25), new int[]{26,22});
        Assert.assertArrayEquals(m00005_04m.findClosedNumbers(Integer.MAX_VALUE), new int[]{-1, -1});
        Assert.assertArrayEquals(m00005_04m.findClosedNumbers(3), new int[]{5, -1});
        Assert.assertArrayEquals(m00005_04m.findClosedNumbers(7), new int[]{11, -1});
        Assert.assertArrayEquals(m00005_04m.findClosedNumbers(11), new int[]{13, 7});
        Assert.assertArrayEquals(m00005_04m.findClosedNumbers(2), new int[]{4, 1});
        Assert.assertArrayEquals(m00005_04m.findClosedNumbers(1), new int[]{2, -1});
    }
}