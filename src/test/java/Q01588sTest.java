import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01588sTest {

    Q01588s q01588s = new Q01588s();

    @Test
    public void sumOddLengthSubarrays() {
        Assert.assertEquals(q01588s.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}), 58);
        Assert.assertEquals(q01588s.sumOddLengthSubarrays(new int[]{1, 2}), 3);
        Assert.assertEquals(q01588s.sumOddLengthSubarrays(new int[]{10, 11, 12}), 66);
    }
}