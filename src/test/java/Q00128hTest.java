import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00128hTest {

    Q00128h q00128h = new Q00128h();

    @Test
    public void longestConsecutive() {
        Assert.assertEquals(q00128h.longestConsecutive(new int[0]), 0);
        Assert.assertEquals(q00128h.longestConsecutive(new int[]{1}), 1);
        Assert.assertEquals(q00128h.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}), 4);
        Assert.assertEquals(q00128h.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}), 9);
    }
}