import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00044mTest {

    J00044m j00044m = new J00044m();

    @Test
    public void findNthDigit() {
        Assert.assertEquals(j00044m.findNthDigit(13), 1);
        Assert.assertEquals(j00044m.findNthDigit(2147483641), 9);
        Assert.assertEquals(j00044m.findNthDigit(788888897), 0);
        Assert.assertEquals(j00044m.findNthDigit(788888890), 1);
        Assert.assertEquals(j00044m.findNthDigit(364), 1);
        Assert.assertEquals(j00044m.findNthDigit(10), 1);
        Assert.assertEquals(j00044m.findNthDigit(11), 0);
        Assert.assertEquals(j00044m.findNthDigit(12), 1);
        Assert.assertEquals(j00044m.findNthDigit(14), 1);
        Assert.assertEquals(j00044m.findNthDigit(15), 2);
        Assert.assertEquals(j00044m.findNthDigit(1), 1);
        Assert.assertEquals(j00044m.findNthDigit(3), 3);
    }

    @Test
    public void findNthDigitAns() {
        Assert.assertEquals(j00044m.findNthDigitAns(2147483641), 9);
        Assert.assertEquals(j00044m.findNthDigitAns(13), 1);
        Assert.assertEquals(j00044m.findNthDigitAns(788888897), 0);
        Assert.assertEquals(j00044m.findNthDigitAns(788888890), 1);
        Assert.assertEquals(j00044m.findNthDigitAns(364), 1);
        Assert.assertEquals(j00044m.findNthDigitAns(10), 1);
        Assert.assertEquals(j00044m.findNthDigitAns(11), 0);
        Assert.assertEquals(j00044m.findNthDigitAns(12), 1);
        Assert.assertEquals(j00044m.findNthDigitAns(14), 1);
        Assert.assertEquals(j00044m.findNthDigitAns(15), 2);
        Assert.assertEquals(j00044m.findNthDigitAns(1), 1);
        Assert.assertEquals(j00044m.findNthDigitAns(3), 3);
    }
}