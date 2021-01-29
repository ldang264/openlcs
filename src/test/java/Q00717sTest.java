import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00717sTest {

    Q00717s_Ans q00717s = new Q00717s_Ans();

    @Test
    public void mergeTrees() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        Assert.assertEquals("3  4  5  4  5  7", q00717s.mergeTrees(t1, t2).toString());
    }
}