import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00047mTest {

    Q00047m q00047m = new Q00047m();

    @Test
    public void permuteUnique() {
        Assert.assertEquals(q00047m.permuteUnique(new int[]{1, 1, 2}).toString(), "[[1, 1, 2], [1, 2, 1], [2, 1, 1]]");
        Assert.assertEquals(q00047m.permuteUnique(new int[]{1, 2, 3}).toString(), "[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]");
    }
}