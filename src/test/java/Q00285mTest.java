import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00285mTest {

    Q00285m q00285m = new Q00285m();

    @Test
    public void inorderSuccessor1() {
        TreeNode root = TreeNode.deserialize("[2,1,3]");
        Assert.assertEquals(q00285m.inorderSuccessor(root, root.left), root);
    }

    @Test
    public void inorderSuccessor2() {
        TreeNode root = TreeNode.deserialize("[2,1,3]");
        Assert.assertNull(q00285m.inorderSuccessor(root, root.right));
    }


    @Test
    public void inorderSuccessor3() {
        TreeNode root = TreeNode.deserialize("[2,1,3]");
        Assert.assertEquals(q00285m.inorderSuccessor(root, root), root.right);
    }
}