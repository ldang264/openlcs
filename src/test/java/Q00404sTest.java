import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00404sTest {

    Q00404s q00404s = new Q00404s();

    @Test
    public void sumOfLeftLeaves() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        Assert.assertEquals(9, q00404s.sumOfLeftLeaves(root));
        root.right = new TreeNode(20);
        Assert.assertEquals(9, q00404s.sumOfLeftLeaves(root));
        root.right.left = new TreeNode(15);
        Assert.assertEquals(24, q00404s.sumOfLeftLeaves(root));
        root.right.right = new TreeNode(7);
        Assert.assertEquals(24, q00404s.sumOfLeftLeaves(root));
    }
}