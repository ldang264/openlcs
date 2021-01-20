import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00111sTest {

    Q00111s md = new Q00111s();

    @Test
    public void minDepth() {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        Assert.assertEquals(2, md.minDepth(root1));

        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);
        Assert.assertEquals(5, md.minDepth(root2));
    }
}