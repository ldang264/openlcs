import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00230mTest {

    Q00230m q00230m = new Q00230m();

    @Test
    public void kthSmallest() {
        TreeNode root = TreeNode.deserialize("3,1,4,null,2");
        Assert.assertEquals(q00230m.kthSmallest(root, 1), 1);
    }
}