import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class Q00025hTest {

    Q00025h q00025h = new Q00025h();

    @Test
    public void reverseKGroup() {
        Assert.assertEquals(q00025h.reverseKGroup(ListNode.deserialize("[1,2,3,4]"), 2).toString(), "[2,1,4,3]");
        Assert.assertEquals(q00025h.reverseKGroup(ListNode.deserialize("[1,2,3,4,5]"), 2).toString(), "[2,1,4,3,5]");
        Assert.assertEquals(q00025h.reverseKGroup(ListNode.deserialize("[1,2,3,4,5]"), 3).toString(), "[3,2,1,4,5]");
        Assert.assertEquals(q00025h.reverseKGroup(ListNode.deserialize("[1,2,3,4,5]"), 5).toString(), "[5,4,3,2,1]");
        Assert.assertEquals(q00025h.reverseKGroup(ListNode.deserialize("[1,2,3,4,5]"), 4).toString(), "[4,3,2,1,5]");
    }
}