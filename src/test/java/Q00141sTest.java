import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class Q00141sTest {

    Q00141s q00141s = new Q00141s();

    @Test
    public void hasCycle() {
        ListNode l1 = new ListNode(3);
        ListNode l10 = new ListNode(2);
        l1.next = l10;
        l10.next = new ListNode(0);
        ListNode l11 = new ListNode(-4);
        l10.next.next = l11;
        l11.next = l10;
        Assert.assertTrue(q00141s.hasCycle(l1));

        ListNode l2 = new ListNode(3);
        ListNode l20 = new ListNode(2);
        l2.next = l20;
        l20.next = l2;
        Assert.assertTrue(q00141s.hasCycle(l2));

        ListNode l3 = new ListNode(1);
        Assert.assertFalse(q00141s.hasCycle(l3));
    }
}