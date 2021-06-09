import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Q00338sTest {

    Q00338s q00338s = new Q00338s();

    @Test
    public void countBits() {
        Assert.assertEquals("[0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2]", Arrays.toString(q00338s.countBits(10)));
        Assert.assertEquals("[0, 1, 1, 2, 1, 2, 2, 3, 1, 2]", Arrays.toString(q00338s.countBits(9)));
        Assert.assertEquals("[0, 1, 1, 2, 1, 2, 2, 3, 1]", Arrays.toString(q00338s.countBits(8)));
        Assert.assertEquals("[0, 1, 1, 2, 1, 2, 2, 3]", Arrays.toString(q00338s.countBits(7)));
        Assert.assertEquals("[0, 1, 1, 2, 1, 2, 2]", Arrays.toString(q00338s.countBits(6)));
        Assert.assertEquals("[0, 1, 1, 2, 1, 2]", Arrays.toString(q00338s.countBits(5)));
        Assert.assertEquals("[0, 1, 1, 2, 1]", Arrays.toString(q00338s.countBits(4)));
        Assert.assertEquals("[0, 1, 1, 2]", Arrays.toString(q00338s.countBits(3)));
        Assert.assertEquals("[0, 1, 1]", Arrays.toString(q00338s.countBits(2)));
        Assert.assertEquals("[0, 1]", Arrays.toString(q00338s.countBits(1)));
        Assert.assertEquals("[0]", Arrays.toString(q00338s.countBits(0)));
    }
}