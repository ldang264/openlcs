import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class M00002_05mTest {

    M00002_05m m00002_05m = new M00002_05m();

    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(2);
        Assert.assertEquals(m00002_05m.addTwoNumbers(l1, l2).toString(), "2 1 9");
    }

    @Test
    public void addTwoNumbers1() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(1);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(2);
        Assert.assertEquals(m00002_05m.addTwoNumbers(l1, l2).toString(), "2 1 3");
    }

    @Test
    public void addTwoNumbers2() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        Assert.assertEquals(m00002_05m.addTwoNumbers(l1, l2).toString(), "2 1 7");
    }
}