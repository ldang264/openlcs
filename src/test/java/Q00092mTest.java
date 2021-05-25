import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class Q00092mTest {

    Q00092m q00092m = new Q00092m();

    @Test
    public void reverseBetween() {
        Assert.assertEquals(q00092m.reverseBetween(ListNode.deserialize("[1,2,3,4,5]"), 1, 1).toString(), "[1,2,3,4,5]");
        Assert.assertEquals(q00092m.reverseBetween(ListNode.deserialize("[1,2,3,4,5]"), 2, 4).toString(), "[1,4,3,2,5]");
        Assert.assertEquals(q00092m.reverseBetween(ListNode.deserialize("[1,2,3,4,5]"), 1, 5).toString(), "[5,4,3,2,1]");
        Assert.assertEquals(q00092m.reverseBetween(ListNode.deserialize("[1,2,3,4,5]"), 1, 4).toString(), "[4,3,2,1,5]");
        Assert.assertEquals(q00092m.reverseBetween(ListNode.deserialize("[1,2,3,4,5]"), 2, 5).toString(), "[1,5,4,3,2]");
    }
}