import junit.framework.TestCase;
import org.junit.Assert;
import tool.TreeNode;

public class Q00222mTest extends TestCase {

    public void testCountNodes() {
        Q00222m cn = new Q00222m();
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        root.left = t1;
        root.right = t2;
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(5);
        t2.left = new TreeNode(6);
        Assert.assertEquals(6, cn.countNodes(root));
    }
}