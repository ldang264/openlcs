package q00179m;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LargestNumberTest {

    LargestNumber ln = new LargestNumber();

    @Test
    public void largestNumber() {
        Assert.assertEquals("1113111311", ln.largestNumber(new int[]{111311, 1113}));
        Assert.assertEquals("83088308830", ln.largestNumber(new int[]{8308, 8308, 830}));
        Assert.assertEquals("210", ln.largestNumber(new int[]{10, 2}));
        Assert.assertEquals("9534330", ln.largestNumber(new int[]{3, 30, 34, 5, 9}));
        Assert.assertEquals("1", ln.largestNumber(new int[]{1}));
        Assert.assertEquals("10", ln.largestNumber(new int[]{10}));
        Assert.assertEquals("0", ln.largestNumber(new int[]{0, 0}));
    }
}