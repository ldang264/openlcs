import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00118sTest {

    Q00118s q00118s = new Q00118s();

    @Test
    public void generate() {
        Assert.assertEquals("[]", q00118s.generate(-1).toString());
        Assert.assertEquals("[]", q00118s.generate(0).toString());
        Assert.assertEquals("[[1]]", q00118s.generate(1).toString());
        Assert.assertEquals("[[1], [1, 1]]", q00118s.generate(2).toString());
        Assert.assertEquals("[[1], [1, 1], [1, 2, 1]]", q00118s.generate(3).toString());
        Assert.assertEquals("[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]", q00118s.generate(4).toString());
    }
}