import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00437mTest {

    Q00437m q00437m = new Q00437m();

    @Test
    public void pathSum() {
        Assert.assertEquals(q00437m.pathSum(TreeNode.deserialize("[10,5,-3,3,2,null,11,3,-2,null,1]"), 8), 3);
    }
}