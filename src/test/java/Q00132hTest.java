import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00132hTest {

    Q00132h q00132h = new Q00132h();

    @Test
    public void minCut() {
        Assert.assertEquals(q00132h.minCut("baabc"), 1);
        Assert.assertEquals(q00132h.minCut("aaabaa"), 1);
        Assert.assertEquals(q00132h.minCut("baab"), 0);
        Assert.assertEquals(q00132h.minCut("aab"), 1);
        Assert.assertEquals(q00132h.minCut("a"), 0);
        Assert.assertEquals(q00132h.minCut("ab"), 1);
        Assert.assertEquals(q00132h.minCut("eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj"), 42);
    }
}