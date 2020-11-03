package q00206s;

import org.junit.Test;
import tool.ListNode;

import static org.junit.Assert.*;

public class ListNode_ReverseListTest {

    ListNode_ReverseList rl = new ListNode_ReverseList();

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