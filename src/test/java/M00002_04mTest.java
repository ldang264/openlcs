import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class M00002_04mTest {

    M00002_04m m00002_04m = new M00002_04m();

    @Test
    public void partition() {
        // 3->5->8->5->10->2->1
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        Assert.assertEquals(m00002_04m.partition(head, 5).toString(), "3 2 1 10 8 5 5");
    }

    @Test
    public void partition1() {
        // 2->1->3
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        Assert.assertEquals(m00002_04m.partition(head, 2).toString(), "1 3 2");
    }

    @Test
    public void partition2() {
        // 1->1
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        Assert.assertEquals(m00002_04m.partition(head, 0).toString(), "1 1");
    }

    @Test
    public void partition3() {
        // 1->1
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        Assert.assertEquals(m00002_04m.partition(head, 1).toString(), "1 1");
    }

    @Test
    public void partition4() {
        // 1->1
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        Assert.assertEquals(m00002_04m.partition(head, 2).toString(), "1 1");
    }
}