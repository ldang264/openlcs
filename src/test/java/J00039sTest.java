import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00039sTest {

    J00039s j00039s = new J00039s();

    @Test
    public void majorityElement() {
        Assert.assertEquals(j00039s.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}), 2);
        Assert.assertEquals(j00039s.majorityElement(new int[]{1, 2, 3, 2, 5, 2, 5, 2, 2}), 2);
        Assert.assertEquals(j00039s.majorityElement(new int[]{1, 2, 3, 2, 5, 2, 2, 2}), 2);
    }
}