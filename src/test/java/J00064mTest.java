import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00064mTest {

    J00064m j00064m = new J00064m();

    @Test
    public void sumNums() {
        Assert.assertEquals(j00064m.sumNums(1), 1);
        Assert.assertEquals(j00064m.sumNums(2), 3);
        Assert.assertEquals(j00064m.sumNums(3), 6);
        Assert.assertEquals(j00064m.sumNums(4), 10);
        Assert.assertEquals(j00064m.sumNums(9), 45);
    }
}