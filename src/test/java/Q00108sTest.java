import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00108sTest {
    Q00108s q00108s = new Q00108s();

    @Test
    public void sortedArrayToBST() {
        TreeNode treeNode = q00108s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        Assert.assertEquals(treeNode.toString(), "[0,-10,5,null,-3,null,9,null,null,null,null]");
    }

    @Test
    public void sortedArrayToBST1() {
        TreeNode treeNode = q00108s.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        Assert.assertEquals(treeNode.toString(), "[3,1,5,0,2,4,6,null,null,null,null,null,null,null,7,null,null]");
    }
}