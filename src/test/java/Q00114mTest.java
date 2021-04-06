import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00114mTest {
    Q00114m f = new Q00114m();

    @Test
    public void flatten() {
        TreeNode root = TreeNode.deserialize("1,2,5,3,4,null,6");
        f.flatten(root);
        Assert.assertEquals(root.toString(), "1,null,2,null,3,null,4,null,5,null,6,null,null");
    }
}