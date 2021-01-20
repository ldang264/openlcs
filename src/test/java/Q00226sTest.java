import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00226sTest {

    Q00226s ti = new Q00226s();

    @Test
    public void invertTree1() {
        Assert.assertNull(ti.invertTree(null));
    }

    @Test
    public void invertTree2() {
        TreeNode root = new TreeNode(1);
        TreeNode node = ti.invertTree(root);
        System.out.println(node);
    }

    @Test
    public void invertTree3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode node = ti.invertTree(root);
        System.out.println(node);
    }

    @Test
    public void invertTree4() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        TreeNode node = ti.invertTree(root);
        System.out.println(node);
    }

    @Test
    public void invertTree5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode node = ti.invertTree(root);
        System.out.println(node);
    }

    @Test
    public void invertTree6() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode node = ti.invertTree(root);
        System.out.println(node);
    }
}