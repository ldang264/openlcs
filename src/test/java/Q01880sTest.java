import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01880sTest {

    Q01880s q01880s = new Q01880s();

    @Test
    public void isSumEqual() {
        Assert.assertTrue(q01880s.isSumEqual("acb", "cba", "cdb"));
        Assert.assertFalse(q01880s.isSumEqual("aaa", "a", "aab"));
        Assert.assertTrue(q01880s.isSumEqual("aaa", "a", "aaaa"));
    }
}