import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00060hTest {

    Q00060h q00060h = new Q00060h();

    @Test
    public void getPermutation() {
        Assert.assertEquals(q00060h.getPermutation(1, 1), "1");
        Assert.assertEquals(q00060h.getPermutation(2, 1), "12");
        Assert.assertEquals(q00060h.getPermutation(2, 2), "21");
        Assert.assertEquals(q00060h.getPermutation(3, 4), "231");
        Assert.assertEquals(q00060h.getPermutation(3, 2), "132");
        Assert.assertEquals(q00060h.getPermutation(3, 1), "123");
        Assert.assertEquals(q00060h.getPermutation(3, 3), "213");
        Assert.assertEquals(q00060h.getPermutation(3, 5), "312");
        Assert.assertEquals(q00060h.getPermutation(3, 6), "321");
        Assert.assertEquals(q00060h.getPermutation(4, 9), "2314");
    }
}