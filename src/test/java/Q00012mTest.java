import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00012mTest {

    Q00012m q00012m = new Q00012m();

    @Test
    public void intToRoman() {
        Assert.assertEquals("III", q00012m.intToRoman(3));
        Assert.assertEquals("IV", q00012m.intToRoman(4));
        Assert.assertEquals("IX", q00012m.intToRoman(9));
        Assert.assertEquals("LVIII", q00012m.intToRoman(58));
        Assert.assertEquals("MCMXCIV", q00012m.intToRoman(1994));
        Assert.assertEquals("XXVII", q00012m.intToRoman(27));
    }
}