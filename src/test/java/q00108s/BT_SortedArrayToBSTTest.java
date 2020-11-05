package q00108s;

import org.junit.Test;
import tool.TreeNode;

import static org.junit.Assert.*;

public class BT_SortedArrayToBSTTest {
    BT_SortedArrayToBST satb = new BT_SortedArrayToBST();

    @Test
    public void sortedArrayToBST() {
        TreeNode treeNode = satb.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }

    @Test
    public void sortedArrayToBST1() {
        TreeNode treeNode = satb.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        System.out.println(treeNode);
    }
}