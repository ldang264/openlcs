import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00377mTest {

    Q00377m q00377m = new Q00377m();

    @Test
    public void combinationSum4() {
        Assert.assertEquals(q00377m.combinationSum4(new int[]{1, 2, 3}, 4), 7);
        Assert.assertEquals(q00377m.combinationSum4(new int[]{9}, 3), 0);
    }
}