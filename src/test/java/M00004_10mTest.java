import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class M00004_10mTest {

    M00004_10m m00004_10m = new M00004_10m();

    @Test
    public void checkSubTree() {
        TreeNode t1 = TreeNode.deserialize("1, 5, 2, 47, 7, 6, 3, null, null, 59, 22, null, 16, 9, 4, null, null, 60, 26, 20, null, 10, 11, 33, 8, null, null, 53, 28, 35, 49, 12, 13, null, 15, null, null, 41, null, null, null, null, 30, 37, 45, null, null, 23, 19, null, 14, 39, 18, 62, null, null, null, 52, null, null, 61, 40, null, 21, 27, 17, 32, null, 51, 31, null, null, null, null, null, null, null, null, 43, 48, 24, null, 44, 29, null, null, 46, null, 54, 50, 38, 58, null, null, null, 25, 34, null, null, null, null, null, null, null, null, null, null, 56, null, 63, null, null, null, null, 36, null, null, null, null, 42, 57, 55, 64");
        TreeNode t2 = new TreeNode(33);
        Assert.assertTrue(m00004_10m.checkSubTree(t1, t2));
    }
}