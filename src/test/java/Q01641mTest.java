import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01641mTest {

    Q01641m q01641m = new Q01641m();

    @Test
    public void countVowelStrings() {
        Assert.assertEquals(15, q01641m.countVowelStrings(2));
        Assert.assertEquals(35, q01641m.countVowelStrings(3));
        Assert.assertEquals(70, q01641m.countVowelStrings(4));
        Assert.assertEquals(126, q01641m.countVowelStrings(5));
        Assert.assertEquals(66045, q01641m.countVowelStrings(33));
        Assert.assertEquals(5, q01641m.countVowelStrings(1));
    }
}