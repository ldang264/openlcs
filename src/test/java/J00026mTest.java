import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class J00026mTest {

    J00026m j00026m = new J00026m();

    @Test
    public void isSubStructure() {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);
        TreeNode B1 = new TreeNode(4);
        B1.left = new TreeNode(1);
        Assert.assertTrue(j00026m.isSubStructure(A, B1));
    }
}