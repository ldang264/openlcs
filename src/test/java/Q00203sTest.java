import org.junit.Test;
import tool.ListNode;

public class Q00203sTest {

    Q00203s re = new Q00203s();

    @Test
    public void removeElements() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode ans = re.removeElements(head, 6);
        System.out.println(ans);
    }
}