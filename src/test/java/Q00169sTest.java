import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00169sTest {

    Q00169s q00169s = new Q00169s();

    @Test
    public void majorityElement() {
        Assert.assertEquals(3, q00169s.majorityElement(new int[]{3}));
        Assert.assertEquals(3, q00169s.majorityElement(new int[]{3, 3}));
        Assert.assertEquals(3, q00169s.majorityElement(new int[]{3, 2, 3}));
        Assert.assertEquals(2, q00169s.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}