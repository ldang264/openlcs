import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class M00004_06mTest {

    M00004_06m m00004_06m = new M00004_06m();

    @Test
    public void inorderSuccessor() {
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        five.left = three;
        five.right = six;
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        three.left = two;
        three.right = four;
        TreeNode one = new TreeNode(1);
        two.left = one;
        Assert.assertEquals(m00004_06m.inorderSuccessor(five, three), four);
        Assert.assertEquals(m00004_06m.inorderSuccessor(five, one), two);
        Assert.assertEquals(m00004_06m.inorderSuccessor(five, two), three);
        Assert.assertEquals(m00004_06m.inorderSuccessor(five, four), five);
        Assert.assertEquals(m00004_06m.inorderSuccessor(five, five), six);
        Assert.assertNull(m00004_06m.inorderSuccessor(five, six));
    }
}