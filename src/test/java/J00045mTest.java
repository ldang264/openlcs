import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00045mTest {

    J00045m j00045m = new J00045m();

    @Test
    public void minNumber() {
        Assert.assertEquals(j00045m.minNumber(new int[]{12, 121}), "12112");
        Assert.assertEquals(j00045m.minNumber(new int[]{3, 30, 306}), "303063");
        Assert.assertEquals(j00045m.minNumber(new int[]{0, 2}), "02");
        Assert.assertEquals(j00045m.minNumber(new int[]{0, 1, 2}), "012");
        Assert.assertEquals(j00045m.minNumber(new int[]{10, 2}), "102");
        Assert.assertEquals(j00045m.minNumber(new int[]{3, 30, 34, 5, 9}), "3033459");
    }
}