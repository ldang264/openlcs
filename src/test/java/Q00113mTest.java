import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00113mTest {

    Q00113m q00113m = new Q00113m();

    @Test
    public void pathSum() {
        Assert.assertEquals(q00113m.pathSum(TreeNode.deserialize("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22).toString(), "[[5, 4, 11, 2], [5, 8, 4, 5]]");
        Assert.assertEquals(q00113m.pathSum(TreeNode.deserialize("[1,2,3]"), 5).toString(), "[]");
    }
}