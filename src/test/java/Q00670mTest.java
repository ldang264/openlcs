import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00670mTest {

    Q00670m q00670m = new Q00670m();

    @Test
    public void maximumSwap() {
        Assert.assertEquals(q00670m.maximumSwap(99901), 99910);
        Assert.assertEquals(q00670m.maximumSwap(98368), 98863);
        Assert.assertEquals(q00670m.maximumSwap(324576), 724536);
        Assert.assertEquals(q00670m.maximumSwap(2736), 7236);
        Assert.assertEquals(q00670m.maximumSwap(9973), 9973);
        Assert.assertEquals(q00670m.maximumSwap(9093), 9903);
        Assert.assertEquals(q00670m.maximumSwap(123444), 423441);
    }
}