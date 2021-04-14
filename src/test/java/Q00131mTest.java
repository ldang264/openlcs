import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00131mTest {

    Q00131m q00131m = new Q00131m();

    @Test
    public void partition() {
        Assert.assertEquals(q00131m.partition("aab").toString(), "[[a, a, b], [aa, b]]");
    }
}