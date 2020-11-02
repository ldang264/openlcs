package q00101s;

import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class BT_IsSymmetricBFSTest {

    BT_IsSymmetric_BFS btIS = new BT_IsSymmetric_BFS();

    @Test
    public void isSymmetric() {
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(76);
        TreeNode t3 = new TreeNode(76);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(-4);
        TreeNode t5 = new TreeNode(-4);
        t2.left = t4;
        t3.right = t5;
        TreeNode t6 = new TreeNode(26);
        TreeNode t7 = new TreeNode(-61);
        TreeNode t8 = new TreeNode(-61);
        TreeNode t9 = new TreeNode(-21);
        t4.left = t6;
        t4.right = t7;
        t5.left = t8;
        t5.right = t9;
        Assert.assertFalse(btIS.isSymmetric(t1));
    }

    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Assert.assertTrue(btIS.isSymmetric(t1));
    }
    @Test
    public void test2() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(2);
        t2.left = t4;
        t3.left = t5;
        Assert.assertFalse(btIS.isSymmetric(t1));
    }

    @Test
    public void test3() {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(4);
        t2.right = t4;
        t3.right = t5;
        TreeNode t6 = new TreeNode(2);
        TreeNode t7 = new TreeNode(2);
        t4.left = t6;
        t5.left = t7;
        Assert.assertFalse(btIS.isSymmetric(t1));
    }

    @Test
    public void test4() {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(4);
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(9);
        TreeNode t11 = new TreeNode(8);
        t5.left = t8;
        t5.right = t9;
        t7.left = t10;
        t7.right = t11;
        Assert.assertFalse(btIS.isSymmetric(t1));
    }
}