import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00687mTest {

    Q00687m q00687m = new Q00687m();

    @Test
    public void longestUnivaluePath() {
        Assert.assertEquals(q00687m.longestUnivaluePath(TreeNode.deserialize("[1,4,5,4,4,5]")), 2);
        Assert.assertEquals(q00687m.longestUnivaluePath(TreeNode.deserialize("[5,4,5,1,1,5]")), 2);
    }
}