import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00583mTest {

    Q00583m q00583m = new Q00583m();

    @Test
    public void minDistance() {
        Assert.assertEquals(q00583m.minDistance("leetcode", "etco"), 4);
        Assert.assertEquals(q00583m.minDistance("a", "ab"), 1);
        Assert.assertEquals(q00583m.minDistance("sea", "eat"), 2);
    }
}