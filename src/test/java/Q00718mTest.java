import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00718mTest {

    Q00718m q00718m = new Q00718m();

    @Test
    public void findLength() {
        Assert.assertEquals(q00718m.findLength(new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0}), 9);
        Assert.assertEquals(q00718m.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}), 3);
    }
}