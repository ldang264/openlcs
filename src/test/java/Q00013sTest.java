import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00013sTest {

    Q00013s q00013s = new Q00013s();

    @Test
    public void romanToInt() {
        Assert.assertEquals(q00013s.romanToInt("XXVII"), 27);
        Assert.assertEquals(q00013s.romanToInt("III"), 3);
        Assert.assertEquals(q00013s.romanToInt("IV"), 4);
        Assert.assertEquals(q00013s.romanToInt("IX"), 9);
        Assert.assertEquals(q00013s.romanToInt("LVIII"), 58);
        Assert.assertEquals(q00013s.romanToInt("MCMXCIV"), 1994);
    }
}