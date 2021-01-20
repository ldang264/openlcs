import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import java.util.List;

public class Q00145mTest {

    Q00145m pt = new Q00145m();

    @Test
    public void postorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        List<Integer> list = pt.postorderTraversal(root);
        Assert.assertEquals("[4, 8, 9, 5, 2, 6, 7, 3, 1]", list.toString());
    }
}