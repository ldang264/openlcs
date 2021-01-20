import tool.ListNode;

public class Q00203s {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode prev = hair;
        while (head != null) {
            if (head.val == val) { // 满足相等条件，将prev与head.next相连
                head = prev.next = head.next;
            } else {
                head = head.next;
                prev = prev.next;
            }
        }
        return hair.next;
    }
}
