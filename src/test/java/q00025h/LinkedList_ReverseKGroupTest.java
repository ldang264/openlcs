package q00025h;

import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class LinkedList_ReverseKGroupTest {

    LinkedList_ReverseKGroup rkg = new LinkedList_ReverseKGroup();

    @Test
    public void reverseKGroup() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = rkg.reverseKGroup(head, 2);
        System.out.println(listNode.toString());
    }

    @Test
    public void reverseKGroup1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = rkg.reverseKGroup(head, 3);
        System.out.println(listNode.toString());
    }

    @Test
    public void reverseKGroup2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = rkg.reverseKGroup(head, 4);
        System.out.println(listNode.toString());
    }

    @Test
    public void reverseKGroup3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = rkg.reverseKGroup(head, 5);
        System.out.println(listNode.toString());
    }
}