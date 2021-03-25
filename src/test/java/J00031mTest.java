import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00031mTest {

    J00031m j00031m = new J00031m();

    @Test
    public void validateStackSequences() {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped1 = new int[]{4, 5, 3, 2, 1};
        Assert.assertTrue(j00031m.validateStackSequences(pushed, popped1));
        int[] popped2 = new int[]{4, 3, 5, 1, 2};
        Assert.assertFalse(j00031m.validateStackSequences(pushed, popped2));
    }
}