import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class J00032_3mTest {

    J00032_3m j00032_3m = new J00032_3m();

    @Test
    public void levelOrder() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(4);
        Assert.assertEquals(j00032_3m.levelOrder(root).toString(), "[[3], [20, 9], [15, 7], [4, 2]]");
    }
}