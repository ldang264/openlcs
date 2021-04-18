import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01365sTest {

    Q01365s q01365s = new Q01365s();

    @Test
    public void smallerNumbersThanCurrent() {
        Assert.assertArrayEquals(q01365s.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3}), new int[]{4, 0, 1, 1, 3});
        Assert.assertArrayEquals(q01365s.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7}), new int[]{0, 0, 0, 0});
        Assert.assertArrayEquals(q01365s.smallerNumbersThanCurrent(new int[]{6,5,4,8}), new int[]{2, 1, 0, 3});
    }
}