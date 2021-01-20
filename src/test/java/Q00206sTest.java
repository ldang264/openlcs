import org.junit.Test;
import tool.ListNode;

public class Q00206sTest {

    Q00206s rl = new Q00206s();

    @Test
    public void reverseList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(rl.reverseList(head));
    }
}