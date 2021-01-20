import org.junit.Test;
import tool.TreeNode;

public class Q00114mTest {
    Q00114m f = new Q00114m();

    @Test
    public void flatten() {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(5);
        root.left = t1;
        root.right = t2;
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(4);
        t2.left = new TreeNode(6);
        t2.right = new TreeNode(7);
        f.flatten(root);
        System.out.println(root);
    }
}