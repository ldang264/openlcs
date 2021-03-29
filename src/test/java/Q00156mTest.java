import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00156mTest {

    Q00156m q00156m = new Q00156m();

    @Test
    public void upsideDownBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode ans = q00156m.upsideDownBinaryTree(root);
        Assert.assertEquals(ans.toString(), "4 5 2 3 1 ");
    }
}