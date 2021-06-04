import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00226sTest {

    Q00226s q00226s = new Q00226s();

    @Test
    public void invertTree() {
        Assert.assertNull(q00226s.invertTree(null));
        Assert.assertEquals(q00226s.invertTree(TreeNode.deserialize("[1]")).toString(), "[1,null,null]");
        Assert.assertEquals(q00226s.invertTree(TreeNode.deserialize("[1,2]")).toString(), "[1,null,2,null,null]");
        Assert.assertEquals(q00226s.invertTree(TreeNode.deserialize("[1,null,2]")).toString(), "[1,2,null,null,null]");
        Assert.assertEquals(q00226s.invertTree(TreeNode.deserialize("[1,2,3]")).toString(), "[1,3,2,null,null,null,null]");
        Assert.assertEquals(q00226s.invertTree(TreeNode.deserialize("[1,2,3,4,5,6,7]")).toString(), "[1,3,2,7,6,5,4,null,null,null,null,null,null,null,null]");
    }
}