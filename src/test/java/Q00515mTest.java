import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00515mTest {

    Q00515m q00515m = new Q00515m();

    @Test
    public void largestValues() {
        Assert.assertEquals("[]", q00515m.largestValues(null).toString());
        TreeNode root = new TreeNode(1);
        Assert.assertEquals("[1]", q00515m.largestValues(root).toString());
        root.left = new TreeNode(3);
        Assert.assertEquals("[1, 3]", q00515m.largestValues(root).toString());
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        Assert.assertEquals("[1, 3, 9]", q00515m.largestValues(root).toString());
    }
}