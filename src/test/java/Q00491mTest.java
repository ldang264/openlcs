import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00491mTest {

    Q00491m q00491m = new Q00491m();

    @Test
    public void findSubsequences() {
        Assert.assertEquals(q00491m.findSubsequences(new int[]{1, 2, 2}).toString(), "[[1, 2, 2], [1, 2], [2, 2]]");
        Assert.assertEquals(q00491m.findSubsequences(new int[]{4, 6, 7, 7}).toString(), "[[4, 6, 7, 7], [4, 6, 7], [4, 6], [4, 7, 7], [4, 7], [6, 7, 7], [6, 7], [7, 7]]");
    }
}