package q00082m;

import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class DeleteDuplicatesTest {

    DeleteDuplicates dd = new DeleteDuplicates();

    @Test
    public void deleteDuplicates1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        Assert.assertEquals("1 2 5", dd.deleteDuplicates(head).toString());
    }

    @Test
    public void deleteDuplicates2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        Assert.assertEquals("2 3", dd.deleteDuplicates(head).toString());
    }

    @Test
    public void deleteDuplicates3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        Assert.assertEquals("1", dd.deleteDuplicates(head).toString());
    }

    @Test
    public void deleteDuplicates4() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        Assert.assertNull(dd.deleteDuplicates(head));
    }
}