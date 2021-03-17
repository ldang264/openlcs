import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00113mTest {

    Q00113m q00113m = new Q00113m();

    @Test
    public void pathSum() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        Assert.assertEquals(q00113m.pathSum(root, 22).toString(), "[[5, 4, 11, 2], [5, 8, 4, 5]]");
    }
}