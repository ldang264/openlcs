import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class M00004_05mTest {

    M00004_05m m00004_05m = new M00004_05m();

    @Test
    public void isValidBST() {
        Assert.assertFalse(m00004_05m.isValidBST(TreeNode.deserialize("3,1,5,0,2,4,6,null,null,null,3")));
    }
}