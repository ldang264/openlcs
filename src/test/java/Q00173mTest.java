import org.junit.Assert;
import org.junit.Test;
import tool.TreeNode;

public class Q00173mTest {

    @Test
    public void test1() {
        Q00173m bSTIterator = new Q00173m(TreeNode.deserialize("7,3,15,null,null,9,20"));
        Assert.assertEquals(bSTIterator.next(), 3);    // 返回 3
        Assert.assertEquals(bSTIterator.next(), 7);    // 返回 7
        Assert.assertTrue(bSTIterator.hasNext()); // 返回 True
        Assert.assertEquals(bSTIterator.next(), 9);    // 返回 9
        Assert.assertTrue(bSTIterator.hasNext()); // 返回 True
        Assert.assertEquals(bSTIterator.next(), 15);    // 返回 15
        Assert.assertTrue(bSTIterator.hasNext()); // 返回 True
        Assert.assertEquals(bSTIterator.next(), 20);    // 返回 20
        Assert.assertFalse(bSTIterator.hasNext()); // 返回 False
    }

    @Test
    public void test2() {
        Q00173m bSTIterator = new Q00173m(TreeNode.deserialize("7"));
        Assert.assertTrue(bSTIterator.hasNext()); // 返回 True
        Assert.assertEquals(bSTIterator.next(), 7);    // 返回 3
        Assert.assertFalse(bSTIterator.hasNext()); // 返回 False
    }

}