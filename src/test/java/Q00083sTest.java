import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class Q00083sTest {

    Q00083s dd = new Q00083s();

    @Test
    public void deleteDuplicates() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        Assert.assertEquals(String.valueOf(dd.deleteDuplicates(head1)), "[1,2]");

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);
        Assert.assertEquals(String.valueOf(dd.deleteDuplicates(head2)), "[1,2,3]");
    }
}