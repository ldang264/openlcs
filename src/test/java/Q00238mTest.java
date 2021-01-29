import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Q00238mTest {

    Q00238m q00238m = new Q00238m();

    @Test
    public void productExceptSelf() {
        Assert.assertEquals("[24, 12, 8, 6]", Arrays.toString(q00238m.productExceptSelf(new int[]{1, 2, 3, 4})));
        Assert.assertEquals("[0, 0, 0]", Arrays.toString(q00238m.productExceptSelf(new int[]{0, 4, 0})));
        Assert.assertEquals("[0, 0]", Arrays.toString(q00238m.productExceptSelf(new int[]{0, 0})));
        Assert.assertEquals("[0, 1]", Arrays.toString(q00238m.productExceptSelf(new int[]{1, 0})));
    }
}