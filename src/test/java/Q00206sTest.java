import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class Q00206sTest {

    Q00206s q00206s = new Q00206s();

    @Test
    public void reverseList() {
        ListNode head = ListNode.deserialize("[1,2,3,4,5]");
        Assert.assertEquals(q00206s.reverseList(head).toString(), "[5,4,3,2,1]");
    }
}