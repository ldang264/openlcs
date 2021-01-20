import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class J00022sTest {

    J00022s j00022s = new J00022s();

    @Test
    public void getKthFromEnd() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Assert.assertEquals("4 5", j00022s.getKthFromEnd(head, 2).toString());
    }
}