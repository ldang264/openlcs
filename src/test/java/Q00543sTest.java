import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00543sTest {

    Q00543s q00543s = new Q00543s();

    @Test
    public void diameterOfBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Assert.assertEquals(3, q00543s.diameterOfBinaryTree(root));
    }

    @Test
    public void diameterOfBinaryTree1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        Assert.assertEquals(3, q00543s.diameterOfBinaryTree(root));
    }

    @Test
    public void diameterOfBinaryTree2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        Assert.assertEquals(5, q00543s.diameterOfBinaryTree(root));
    }
}