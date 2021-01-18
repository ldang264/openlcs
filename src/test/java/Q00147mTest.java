import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class Q00147mTest {

    Q00147m q00147m = new Q00147m();

    @Test
    public void insertionSortList() {
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);
        Assert.assertEquals("1 2 3 4", q00147m.insertionSortList(head1).toString());

        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);
        Assert.assertEquals("-1 0 3 4 5", q00147m.insertionSortList(head2).toString());
    }
}