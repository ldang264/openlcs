import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00450mTest {

    Q00450m q00450m = new Q00450m();

    @Test
    public void deleteNode1() {
        TreeNode root = TreeNode.deserialize("[5,3,6,2,4,null,7]");
        q00450m.deleteNode(root, 2);
        Assert.assertEquals(root.toString(), "[5,3,6,null,4,null,7,null,null,null,null]");
    }

    @Test
    public void deleteNode2() {
        TreeNode root = TreeNode.deserialize("5,3,6,2,4,null,7");
        q00450m.deleteNode(root, 3);
        Assert.assertEquals(root.toString(), "[5,2,6,null,4,null,7,null,null,null,null]");
    }

    @Test
    public void deleteNode3() {
        TreeNode root = TreeNode.deserialize("5,3,6,2,4,null,7");
        q00450m.deleteNode(root, 4);
        Assert.assertEquals(root.toString(), "[5,3,6,2,null,null,7,null,null,null,null]");
    }

    @Test
    public void deleteNode4() {
        TreeNode root = TreeNode.deserialize("5,3,6,2,4,null,7");
        q00450m.deleteNode(root, 5);
        Assert.assertEquals(root.toString(), "[4,3,6,2,null,null,7,null,null,null,null]");
    }

    @Test
    public void deleteNode5() {
        TreeNode root = TreeNode.deserialize("5,3,6,2,4,null,7");
        q00450m.deleteNode(root, 6);
        Assert.assertEquals(root.toString(), "[5,3,7,2,4,null,null,null,null,null,null]");
    }

    @Test
    public void deleteNode6() {
        TreeNode root = TreeNode.deserialize("5,3,6,2,4,null,7");
        q00450m.deleteNode(root, 7);
        Assert.assertEquals(root.toString(), "[5,3,6,2,4,null,null,null,null,null,null]");
    }

    @Test
    public void deleteNode7() {
        Assert.assertNull(q00450m.deleteNode(null, 7));
        Assert.assertNull(q00450m.deleteNode(TreeNode.deserialize("[5]"), 5));
    }
}