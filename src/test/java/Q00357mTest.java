import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00357mTest {

    Q00357m q00357m = new Q00357m();

    @Test
    public void countNumbersWithUniqueDigits() {
        Assert.assertEquals(10, q00357m.countNumbersWithUniqueDigits(1));
        Assert.assertEquals(91, q00357m.countNumbersWithUniqueDigits(2));
        Assert.assertEquals(739, q00357m.countNumbersWithUniqueDigits(3));
    }
}