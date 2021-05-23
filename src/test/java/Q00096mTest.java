import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q00096mTest {

    Q00096m q00096m = new Q00096m();

    @Test
    public void numTrees() {
        Assert.assertEquals(q00096m.numTrees(1), 1);
        Assert.assertEquals(q00096m.numTrees(2), 2);
        Assert.assertEquals(q00096m.numTrees(3), 5);
    }
}