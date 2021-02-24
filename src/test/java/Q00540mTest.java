import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00540mTest {

    Q00540m q00540m = new Q00540m();

    @Test
    public void singleNonDuplicate() {
        Assert.assertEquals(1, q00540m.singleNonDuplicate(new int[]{1, 2, 2, 3, 3}));
        Assert.assertEquals(3, q00540m.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 4, 4, 8, 8}));
        Assert.assertEquals(10, q00540m.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        Assert.assertEquals(1, q00540m.singleNonDuplicate(new int[]{1, 2, 2, 3, 3, 4, 4, 8, 8}));
        Assert.assertEquals(2, q00540m.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        Assert.assertEquals(4, q00540m.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 8, 8}));
        Assert.assertEquals(8, q00540m.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 8}));
    }
}