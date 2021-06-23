import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00645sTest {

    Q00645s q00645s = new Q00645s();

    @Test
    public void findErrorNums() {
        Assert.assertArrayEquals(q00645s.findErrorNums(new int[]{8, 7, 3, 5, 3, 6, 1, 4}), new int[]{3, 2});
        Assert.assertArrayEquals(q00645s.findErrorNums(new int[]{1, 2, 2, 4}), new int[]{2, 3});
        Assert.assertArrayEquals(q00645s.findErrorNums(new int[]{1, 1}), new int[]{1, 2});
    }
}