import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00001sTest {

    Q00001s q00001s = new Q00001s();

    @Test
    public void twoSum() {
        Assert.assertArrayEquals(q00001s.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
    }
}