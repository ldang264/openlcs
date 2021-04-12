import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00767mTest {

    Q00767m q00767m = new Q00767m();

    @Test
    public void reorganizeString() {
        Assert.assertEquals(q00767m.reorganizeString("baabb"), "babab");
        Assert.assertEquals(q00767m.reorganizeString("lovvv"), "vlvov");
        Assert.assertEquals(q00767m.reorganizeString("vvvlo"), "vlvov");
        Assert.assertEquals(q00767m.reorganizeString("aaabc"), "abaca");
        Assert.assertEquals(q00767m.reorganizeString("acaca"), "acaca");
        Assert.assertEquals(q00767m.reorganizeString("aaabb"), "ababa");
        Assert.assertEquals(q00767m.reorganizeString("aaab"), "");
        Assert.assertEquals(q00767m.reorganizeString("aab"), "aba");
    }
}