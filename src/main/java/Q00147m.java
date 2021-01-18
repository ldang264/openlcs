import tool.ListNode;

public class Q00147m {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode curr = head.next, cp = head, ha;
        ListNode hn;
        while (curr != null) {
            ha = hair;
            boolean insert = false;
            while ((hn = ha.next) != curr) {
                insert = curr.val < hn.val;
                if (insert) {
                    ListNode cn = curr.next;
                    ha.next = curr;
                    curr.next = hn;
                    cp.next = cn;
                    curr = cn;
                    break;
                } else {
                    ha = ha.next;
                }
            }
            if (!insert) {
                cp = cp.next;
                curr = curr.next;
            }
        }
        return hair.next;
    }
}
