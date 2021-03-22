import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import java.util.Arrays;

public class Q00508mTest {

    Q00508m q00508m = new Q00508m();

    @Test
    public void findFrequentTreeSum1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        Assert.assertEquals(Arrays.toString(q00508m.findFrequentTreeSum(root)), "[2, -3, 4]");
    }

    @Test
    public void findFrequentTreeSum2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        Assert.assertEquals(Arrays.toString(q00508m.findFrequentTreeSum(root)), "[2]");
    }

    @Test
    public void findFrequentTreeSum3() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(-1);
        Assert.assertEquals(Arrays.toString(q00508m.findFrequentTreeSum(root)), "[2]");
    }

}