import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class Q00142mTest {

    Q00142m dc = new Q00142m();

    @Test
    public void detectCycle() {
        ListNode head = new ListNode(3);
        ListNode cycle = new ListNode(2);
        head.next = cycle;
        cycle.next = new ListNode(0);
        cycle.next.next = new ListNode(-4);
        cycle.next.next.next = cycle;
        ListNode res = dc.detectCycle(head);
        Assert.assertEquals(2, res.val);
    }

    @Test
    public void detectCycle1() {
        ListNode head = new ListNode(1);
        ListNode cycle = new ListNode(2);
        head.next = cycle;
        cycle.next = head;
        ListNode res = dc.detectCycle(head);
        Assert.assertEquals(1, res.val);
    }
    @Test
    public void detectCycle2() {
        ListNode head = new ListNode(1);
        ListNode res = dc.detectCycle(head);
        Assert.assertNull(res);
    }

    @Test
    public void detectCycle3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode cycle = new ListNode(3);
        head.next.next = cycle;
        cycle.next = head;
        ListNode res = dc.detectCycle(head);
        Assert.assertEquals(1, res.val);
    }

}