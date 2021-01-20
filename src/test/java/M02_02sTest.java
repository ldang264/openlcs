import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class M02_02sTest {

    M02_02s m02_02s = new M02_02s();

    @Test
    public void kthToLast() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Assert.assertEquals(1, m02_02s.kthToLast(head, 5));
        Assert.assertEquals(2, m02_02s.kthToLast(head, 4));
        Assert.assertEquals(3, m02_02s.kthToLast(head, 3));
        Assert.assertEquals(4, m02_02s.kthToLast(head, 2));
        Assert.assertEquals(5, m02_02s.kthToLast(head, 1));
    }
}