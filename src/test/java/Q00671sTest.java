import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class Q00671sTest {

    Q00671s q00671s = new Q00671s();

    @Test
    public void findSecondMinimumValue() {
        Assert.assertEquals(q00671s.findSecondMinimumValue(TreeNode.deserialize("[2,2,2]")), -1);
        Assert.assertEquals(q00671s.findSecondMinimumValue(TreeNode.deserialize("[1,1,3,1,1,null,null,null,null,2,1]")), 2);
        Assert.assertEquals(q00671s.findSecondMinimumValue(TreeNode.deserialize("[2,2,5,2,3,5,7]")), 3);
        Assert.assertEquals(q00671s.findSecondMinimumValue(TreeNode.deserialize("[2,2,5,3,2,5,7]")), 3);
        Assert.assertEquals(q00671s.findSecondMinimumValue(TreeNode.deserialize("[2,2,5,null,null,5,7]")), 5);
    }
}