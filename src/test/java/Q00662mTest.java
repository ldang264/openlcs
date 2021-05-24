import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00662mTest {

    Q00662m_Todo q00662m = new Q00662m_Todo();

    @Test
    public void widthOfBinaryTree() {
        Assert.assertEquals(q00662m.widthOfBinaryTree(TreeNode.deserialize("[1,3,2,5,3,null,9]")), 4);
        Assert.assertEquals(q00662m.widthOfBinaryTree(TreeNode.deserialize("[1,3,null,5,3]")), 2);
        Assert.assertEquals(q00662m.widthOfBinaryTree(TreeNode.deserialize("[1,3,2,5]")), 2);
        Assert.assertEquals(q00662m.widthOfBinaryTree(TreeNode.deserialize("[1,3,2,5,null,null,9,6,null,null,7]")), 8);
    }
}