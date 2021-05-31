import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00110sTest {

    Q00110s q00110s = new Q00110s();

    @Test
    public void test() {
        Assert.assertTrue(q00110s.isBalanced(TreeNode.deserialize("[3,9,20,null,null,15,7]")));
        Assert.assertFalse(q00110s.isBalanced(TreeNode.deserialize("[1,2,2,3,3,null,null,4,4]")));
        Assert.assertTrue(q00110s.isBalanced(TreeNode.deserialize("[1]")));
        Assert.assertTrue(q00110s.isBalanced(null));
    }

}