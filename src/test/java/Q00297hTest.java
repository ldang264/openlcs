import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00297hTest {

    Q00297h q00297h = new Q00297h();

    @Test
    public void serialize1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String s = q00297h.serialize(root);
        Assert.assertEquals(s, "1,2,3,,,4,5,,,,");
        Assert.assertEquals(q00297h.deserialize(s).toString(), root.toString());
    }

    @Test
    public void serialize2() {
        String s = q00297h.serialize(null);
        Assert.assertEquals(s, "");
        Assert.assertNull(q00297h.deserialize(s));
    }

    @Test
    public void serialize3() {
        TreeNode root = new TreeNode(1);
        String s = q00297h.serialize(root);
        Assert.assertEquals(s, "1,,");
        Assert.assertEquals(q00297h.deserialize(s).toString(), root.toString());
    }

    @Test
    public void serialize4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        String s = q00297h.serialize(root);
        Assert.assertEquals(s, "1,2,,,");
        Assert.assertEquals(q00297h.deserialize(s).toString(), root.toString());
    }

    @Test
    public void serialize5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        String s = q00297h.serialize(root);
        Assert.assertEquals(s, "1,2,3,,,4,5,6,7,,,,,,");
        Assert.assertEquals(q00297h.deserialize(s).toString(), root.toString());
    }

}