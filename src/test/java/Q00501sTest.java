import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00501sTest {

    Q00501s q00501s = new Q00501s();

    @Test
    public void findMode() {
        Assert.assertArrayEquals(q00501s.findMode(TreeNode.deserialize("[1,null,2,2]")), new int[]{2});
        Assert.assertArrayEquals(q00501s.findMode(TreeNode.deserialize("[1,null,2,2,3,null,null,3,3]")), new int[]{3});
        Assert.assertArrayEquals(q00501s.findMode(TreeNode.deserialize("[1,null,2,2,3,null,null,3]")), new int[]{2, 3});
    }
}