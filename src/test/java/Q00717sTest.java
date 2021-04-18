import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00717sTest {

    Q00717s q00717s = new Q00717s();

    @Test
    public void mergeTrees() {
        TreeNode t1 = TreeNode.deserialize("[1,3,2,5,null]");
        TreeNode t2 = TreeNode.deserialize("[2,1,3,null,4,null,7]");
        Assert.assertEquals("[3,4,5,5,4,null,7,null,null,null,null,null,null]", q00717s.mergeTrees(t1, t2).toString());
    }
}