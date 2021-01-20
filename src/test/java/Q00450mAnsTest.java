import org.junit.Test;
import tool.TreeNode;

public class Q00450mAnsTest {
    Q00450m_Ans dn = new Q00450m_Ans();

    @Test
    public void deleteNode1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TreeNode node = dn.deleteNode(root, 5);
        System.out.println(node);
    }

    @Test
    public void deleteNode2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TreeNode node = dn.deleteNode(root, 3);
        System.out.println(node);
    }

    @Test
    public void deleteNode3() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TreeNode node = dn.deleteNode(root, 7);
        System.out.println(node);
    }
}