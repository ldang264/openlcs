import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00538mTest {

    Q00538m q00538m = new Q00538m();

    @Test
    public void convertBST() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(8);
        TreeNode node = q00538m.convertBST(root);
        Assert.assertEquals(" 30  36  36  35  33  21  26  15  8", node.toString());
    }
}