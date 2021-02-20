import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00632mTest {

    Q00632m q00632m = new Q00632m();

    @Test
    public void addOneRow1() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        TreeNode node = q00632m.addOneRow(root, 1, 2);
        Assert.assertEquals("4 1 2 3 1 1 6 5 ", node.toString());
    }

    @Test
    public void addOneRow2() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        TreeNode node = q00632m.addOneRow(root, 1, 3);
        Assert.assertEquals("4 2 1 3 1 1 ", node.toString());
    }

    @Test
    public void addOneRow3() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        TreeNode node = q00632m.addOneRow(root, 1, 1);
        Assert.assertEquals("1 4 2 3 1 ", node.toString());
    }
}