package q00094m;

import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import java.util.List;

import static org.junit.Assert.*;

public class BT_InorderTraversalTest {

    BT_InorderTraversal it = new BT_InorderTraversal();

    @Test
    public void inorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        List<Integer> list = it.inorderTraversal(root);
        Assert.assertEquals("[4, 2, 8, 5, 9, 1, 6, 3, 7]", list.toString());
    }
}