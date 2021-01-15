import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class Q00328mTest {

    Q00328m q00328m = new Q00328m();

    @Test
    public void oddEvenList() {
        ListNode head0 = new ListNode(1);
        head0.next = new ListNode(2);
        head0.next.next = new ListNode(3);
        head0.next.next.next = new ListNode(4);
        head0.next.next.next.next = new ListNode(5);
        head0.next.next.next.next.next = new ListNode(6);
        head0.next.next.next.next.next.next = new ListNode(7);
        head0.next.next.next.next.next.next.next = new ListNode(8);
        Assert.assertEquals("1 3 5 7 2 4 6 8", q00328m.oddEvenList(head0).toString());

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        Assert.assertEquals("1 3 5 2 4", q00328m.oddEvenList(head1).toString());

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(5);
        head2.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next.next = new ListNode(7);
        Assert.assertEquals("2 3 6 7 1 5 4", q00328m.oddEvenList(head2).toString());
    }
}