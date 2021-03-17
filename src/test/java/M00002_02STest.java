import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

public class M00002_02STest {

    M00002_02s m00002_02S = new M00002_02s();

    @Test
    public void kthToLast() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Assert.assertEquals(1, m00002_02S.kthToLast(head, 5));
        Assert.assertEquals(2, m00002_02S.kthToLast(head, 4));
        Assert.assertEquals(3, m00002_02S.kthToLast(head, 3));
        Assert.assertEquals(4, m00002_02S.kthToLast(head, 2));
        Assert.assertEquals(5, m00002_02S.kthToLast(head, 1));
    }
}