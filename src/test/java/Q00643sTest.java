import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00643sTest {

    Q00643s q00643s = new Q00643s();

    @Test
    public void findMaxAverage() {
        Assert.assertEquals(q00643s.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4), 12.75, 0.01);
    }
}