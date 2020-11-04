package q00222m;

import junit.framework.TestCase;
import org.junit.Assert;
import tool.TreeNode;

public class BT_CountNodesTest extends TestCase {

    public void testCountNodes() {
        BT_CountNodes cn = new BT_CountNodes();
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