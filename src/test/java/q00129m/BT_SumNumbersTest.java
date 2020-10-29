package q00129m;

import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class BT_SumNumbersTest {

    private static BT_SumNumbers sn = new BT_SumNumbers();

    @Test
    public void sumNumbers1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Assert.assertEquals(25, sn.sumNumbers(root));
    }

    @Test
    public void sumNumbers2() {
        TreeNode root = new TreeNode(4);
        TreeNode t1 = new TreeNode(9);
        root.left = t1;
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(1);
        root.right = new TreeNode(0);
        Assert.assertEquals(1026, sn.sumNumbers(root));
    }

    @Test
    public void sumNumbers3() {
        TreeNode root = new TreeNode(4);
        Assert.assertEquals(4, sn.sumNumbers(root));
    }
}