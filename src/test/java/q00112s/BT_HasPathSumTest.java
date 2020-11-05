package q00112s;

import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class BT_HasPathSumTest {
    BT_HasPathSum hps = new BT_HasPathSum();

    @Test
    public void hasPathSum() {
        TreeNode root = new TreeNode(5);
        Assert.assertTrue(hps.hasPathSum(root, 5));
    }

    @Test
    public void hasPathSum1() {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(8);
        root.left = t1;
        root.right = t2;
        TreeNode t3 = new TreeNode(11);
        t1.left = t3;
        TreeNode t4 = new TreeNode(13);
        TreeNode t5 = new TreeNode(4);
        t2.left = t4;
        t2.right = t5;
        t3.left = new TreeNode(7);
        t3.right = new TreeNode(2);
        t5.right = new TreeNode(1);
        Assert.assertTrue(hps.hasPathSum(root, 22));
    }
}