import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00199mTest {

    Q00199m q00199m = new Q00199m();

    @Test
    public void rightSideView() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        Assert.assertEquals("[1, 3, 5]", q00199m.rightSideView(root).toString());
        root.right.right = new TreeNode(4);
        Assert.assertEquals("[1, 3, 4]", q00199m.rightSideView(root).toString());
    }
}