package q00107s;

import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class LevelOrderBottomTest {

    LevelOrderBottom lob = new LevelOrderBottom();

    @Test
    public void levelOrderBottom() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals("[[15, 7], [9, 20], [3]]", lob.levelOrderBottom(root).toString());
    }
}