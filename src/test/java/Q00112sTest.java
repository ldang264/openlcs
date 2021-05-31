import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00112sTest {
    Q00112s q00112s = new Q00112s();

    @Test
    public void hasPathSum() {
        Assert.assertTrue(q00112s.hasPathSum(TreeNode.deserialize("[5]"), 5));
        Assert.assertFalse(q00112s.hasPathSum(TreeNode.deserialize("[1,2,3]"), 5));
        Assert.assertTrue(q00112s.hasPathSum(TreeNode.deserialize("[5,4,8,11,null,13,4,7,2,null,null,null,1]"), 22));
    }

}