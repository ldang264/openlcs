import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class Q00017mTest {

    Q00017m q00017m = new Q00017m();

    @Test
    public void letterCombinations() {
        List<String> combinations = q00017m.letterCombinations("23");
        Collections.sort(combinations);
        Assert.assertEquals("[ad, ae, af, bd, be, bf, cd, ce, cf]", combinations.toString());
    }

    @Test
    public void letterCombinationsBT() {
        List<String> combinations = q00017m.letterCombinationsBT("23");
        Collections.sort(combinations);
        Assert.assertEquals("[ad, ae, af, bd, be, bf, cd, ce, cf]", combinations.toString());
    }
}