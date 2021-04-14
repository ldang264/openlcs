import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00134mTest {

    Q00134m q00134m = new Q00134m();

    @Test
    public void canCompleteCircuit() {
        Assert.assertEquals(q00134m.canCompleteCircuit(new int[]{1}, new int[]{1}), 0);
        Assert.assertEquals(q00134m.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}), 3);
        Assert.assertEquals(q00134m.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}), -1);
    }
}