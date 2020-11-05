package q00113m;

import org.junit.Test;
import tool.TreeNode;

import java.util.List;

public class BT_PathSumTest {
    BT_PathSum ps = new BT_PathSum();

    @Test
    public void pathSum() {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(8);
        root.left = t1;
        root.right = t2;
        TreeNode t3 = new TreeNode(11);
        t1.left = t3;
        TreeNode t4 = new TreeNode(13);
        TreeNode t5 = new TreeNode(4);
        t2.left = t4;
        t2.right = t5;
        t3.left = new TreeNode(7);
        t3.right = new TreeNode(2);
        t5.left = new TreeNode(5);
        t5.right = new TreeNode(1);
        List<List<Integer>> lists = ps.pathSum(root, 22);
        System.out.println(lists);
    }
}