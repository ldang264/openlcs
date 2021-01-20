import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import java.util.List;

public class Q00144mTest {

    Q00144m pt = new Q00144m();

    @Test
    public void preorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        List<Integer> list = pt.preorderTraversal(root);
        Assert.assertEquals("[1, 2, 4, 5, 8, 9, 3, 6, 7]", list.toString());
    }
}