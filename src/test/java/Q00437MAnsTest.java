import ans.Q00437m_Ans;
import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00437MAnsTest {

    Q00437m_Ans q00437MAns = new Q00437m_Ans();

    @Test
    public void pathSum() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        Assert.assertEquals(q00437MAns.pathSum(root, 8), 3);
    }
}