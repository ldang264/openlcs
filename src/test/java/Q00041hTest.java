import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00041hTest {

    Q00041h q00041h = new Q00041h();

    @Test
    public void firstMissingPositive() {
        Assert.assertEquals(q00041h.firstMissingPositive(new int[]{1, 3, 4}), 2);
        Assert.assertEquals(q00041h.firstMissingPositive(new int[]{3, 4, -1, 1}), 2);
        Assert.assertEquals(q00041h.firstMissingPositive(new int[]{1, 2, 0}), 3);
        Assert.assertEquals(q00041h.firstMissingPositive(new int[]{1, 1, 2}), 3);
        Assert.assertEquals(q00041h.firstMissingPositive(new int[]{7, 8, 9, 11, 12}), 1);
        Assert.assertEquals(q00041h.firstMissingPositive(new int[]{1, 2, 3}), 4);
    }
}