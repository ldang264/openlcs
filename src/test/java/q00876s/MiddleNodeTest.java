package q00876s;

import org.junit.Assert;
import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class MiddleNodeTest {
    
    MiddleNode mn = new MiddleNode();

    @Test
    public void middleNode1() {
        ListNode head = new ListNode(1);
        Assert.assertEquals(head, mn.middleNode(head));
    }

    @Test
    public void middleNode2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Assert.assertEquals(head.next, mn.middleNode(head));
    }

    @Test
    public void middleNode3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Assert.assertEquals(head.next, mn.middleNode(head));
    }

    @Test
    public void middleNode4() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Assert.assertEquals(head.next.next, mn.middleNode(head));
    }

    @Test
    public void middleNode5() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Assert.assertEquals(head.next.next, mn.middleNode(head));
    }
}