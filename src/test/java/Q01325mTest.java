import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q01325mTest {

    Q01325m rln = new Q01325m();

    @Test
    public void removeLeafNodes1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        TreeNode node = rln.removeLeafNodes(root, 2);
        System.out.println(node);
    }

    @Test
    public void removeLeafNodes2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        TreeNode node = rln.removeLeafNodes(root, 3);
        System.out.println(node);
    }

    @Test
    public void removeLeafNodes3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(2);
        TreeNode node = rln.removeLeafNodes(root, 2);
        System.out.println(node);
    }

    @Test
    public void removeLeafNodes4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        TreeNode node = rln.removeLeafNodes(root, 1);
        Assert.assertNull(node);
    }

    @Test
    public void removeLeafNodes5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode node = rln.removeLeafNodes(root, 1);
        Assert.assertEquals(node, root);
    }
}