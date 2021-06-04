import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00222mTest {

    Q00222m cn = new Q00222m();

    @Test
    public void testCountNodes() {
        TreeNode root = TreeNode.deserialize("[1,2,3,4,5,6]");
        Assert.assertEquals(6, cn.countNodes(root));
    }
}