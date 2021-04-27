import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00442mTest {

    Q00442m q00442m = new Q00442m();

    @Test
    public void findDuplicates() {
        Assert.assertEquals(q00442m.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).toString(), "[3, 2]");
        Assert.assertEquals(q00442m.findDuplicates(new int[]{4, 3, 2, 4, 8, 2, 3, 1}).toString(), "[4, 2, 3]");
    }
}