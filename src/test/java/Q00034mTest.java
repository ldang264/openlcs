import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q00034mTest {

    Q00034m q00034m = new Q00034m();

    @Test
    public void searchRange() {
        Assert.assertEquals("[0, 1]", Arrays.toString(q00034m.searchRange(new int[]{2, 2}, 2)));
        Assert.assertEquals("[-1, -1]", Arrays.toString(q00034m.searchRange(new int[]{5,7,7,8,8,10}, 6)));
        Assert.assertEquals("[1, 1]", Arrays.toString(q00034m.searchRange(new int[]{1, 2}, 2)));
        Assert.assertEquals("[0, 0]", Arrays.toString(q00034m.searchRange(new int[]{1}, 1)));
        Assert.assertEquals("[0, 0]", Arrays.toString(q00034m.searchRange(new int[]{1, 2}, 1)));
        Assert.assertEquals("[3, 4]", Arrays.toString(q00034m.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        Assert.assertEquals("[2, 4]", Arrays.toString(q00034m.searchRange(new int[]{5,7,8,8,8,10}, 8)));
        Assert.assertEquals("[3, 3]", Arrays.toString(q00034m.searchRange(new int[]{5,7,7,8,9,10}, 8)));
        Assert.assertEquals("[-1, -1]", Arrays.toString(q00034m.searchRange(new int[]{}, 0)));
        Assert.assertEquals("[-1, -1]", Arrays.toString(q00034m.searchRange(new int[]{1}, 0)));
    }
}