import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q00338mTest {

    Q00338m q00338m = new Q00338m();

    @Test
    public void countBits() {
        Assert.assertEquals("[0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2]", Arrays.toString(q00338m.countBits(10)));
        Assert.assertEquals("[0, 1, 1, 2, 1, 2, 2, 3, 1, 2]", Arrays.toString(q00338m.countBits(9)));
        Assert.assertEquals("[0, 1, 1, 2, 1, 2, 2, 3, 1]", Arrays.toString(q00338m.countBits(8)));
        Assert.assertEquals("[0, 1, 1, 2, 1, 2, 2, 3]", Arrays.toString(q00338m.countBits(7)));
        Assert.assertEquals("[0, 1, 1, 2, 1, 2, 2]", Arrays.toString(q00338m.countBits(6)));
        Assert.assertEquals("[0, 1, 1, 2, 1, 2]", Arrays.toString(q00338m.countBits(5)));
        Assert.assertEquals("[0, 1, 1, 2, 1]", Arrays.toString(q00338m.countBits(4)));
        Assert.assertEquals("[0, 1, 1, 2]", Arrays.toString(q00338m.countBits(3)));
        Assert.assertEquals("[0, 1, 1]", Arrays.toString(q00338m.countBits(2)));
        Assert.assertEquals("[0, 1]", Arrays.toString(q00338m.countBits(1)));
        Assert.assertEquals("[0]", Arrays.toString(q00338m.countBits(0)));
    }
}