package q00236m_todo;

import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class LowestCommonAncestorTest {

    LowestCommonAncestor lca = new LowestCommonAncestor();

    @Test
    public void lowestCommonAncestor1() {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        root.left = p;
        root.right = q;
        p.left = new TreeNode(6);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(7);
        p.right.right = new TreeNode(4);
        q.left = new TreeNode(0);
        q.right = new TreeNode(8);
        Assert.assertEquals(3, lca.lowestCommonAncestor(root, p, q).val);
    }

    @Test
    public void lowestCommonAncestor2() {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        root.left = p;
        root.right = q;
        p.left = new TreeNode(6);
        p.right = new TreeNode(2);
        TreeNode qq = new TreeNode(4);
        p.right.left = new TreeNode(7);
        p.right.right = qq;
        q.left = new TreeNode(0);
        q.right = new TreeNode(8);
        Assert.assertEquals(5, lca.lowestCommonAncestor(root, p, qq).val);
    }
}