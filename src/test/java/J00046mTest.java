import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00046mTest {

    J00046m j00046m = new J00046m();

    @Test
    public void translateNum() {
        Assert.assertEquals(j00046m.translateNum(506), 1);
        Assert.assertEquals(j00046m.translateNum(100000000), 2);
        Assert.assertEquals(j00046m.translateNum(12258), 5);
    }
}