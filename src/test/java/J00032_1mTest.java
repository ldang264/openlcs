import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import java.util.Arrays;

import static org.junit.Assert.*;

public class J00032_1mTest {

    J00032_1m j00032_1m = new J00032_1m();

    @Test
    public void levelOrder() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(Arrays.toString(j00032_1m.levelOrder(root)), "[3, 9, 20, 15, 7]");
    }
}