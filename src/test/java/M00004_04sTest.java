import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class M00004_04sTest {

    M00004_04s m00004_04s = new M00004_04s();

    @Test
    public void isBalanced() {
        Assert.assertFalse(m00004_04s.isBalanced(TreeNode.deserialize("1,2,2,3,null,null,3,4,null,null,4")));
        Assert.assertTrue(m00004_04s.isBalanced(TreeNode.deserialize("3,9,20,null,null,15,7")));
        Assert.assertFalse(m00004_04s.isBalanced(TreeNode.deserialize("1,2,2,3,3,null,null,4,4")));
    }
}