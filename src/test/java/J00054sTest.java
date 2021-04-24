import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class J00054sTest {

    J00054s j00054s = new J00054s();

    @Test
    public void kthLargest() {
        Assert.assertEquals(j00054s.kthLargest(TreeNode.deserialize("[3,1,4,null,2]"), 1), 4);
        Assert.assertEquals(j00054s.kthLargest(TreeNode.deserialize("[5,3,6,2,4,null,null,1]"), 3), 4);
    }
}