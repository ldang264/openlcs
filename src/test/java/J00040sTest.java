import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00040sTest {

    J00040s j00040s = new J00040s();

    @Test
    public void getLeastNumbers() {
        Assert.assertArrayEquals(j00040s.getLeastNumbers(new int[0], 0), new int[0]);
        Assert.assertArrayEquals(j00040s.getLeastNumbers(new int[]{1}, 0), new int[0]);
        Assert.assertArrayEquals(j00040s.getLeastNumbers(new int[]{1}, 1), new int[]{1});
        Assert.assertArrayEquals(j00040s.getLeastNumbers(new int[]{3, 2, 1}, 2), new int[]{1, 2});
        Assert.assertArrayEquals(j00040s.getLeastNumbers(new int[]{0, 1, 2, 1}, 1), new int[]{0});
    }
}