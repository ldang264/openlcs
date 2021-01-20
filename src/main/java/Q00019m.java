import tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00019m {

    public static void main(String[] args) {
        Q00019m rnfe = new Q00019m();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(l1);
        System.out.println(rnfe.removeNthFromEnd(l1, 5));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        int index = 0;
        while (index < n) {
            fast = fast.next;
            index++;
        }
        if (fast == null) {
            return head.next;
        }
        fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }






    /**
     * 快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int i=1;
        ListNode fast = head, slow = head; //快慢指针均指向head
        while (fast != null) {
            if (i > n + 1) { // 当fast走完n+1时，慢指针开始走（之所以n+1是因为slow指向head，用了1）
                slow = slow.next;
            }
            i++;
            fast = fast.next;
        }
        if (i == n + 1) { // 若遍历结束都没满足上面的if，则说明删除的是头节点（这里避免在while中初始化slow）
            return head.next;
        }
        slow.next = slow.next.next; //删除慢指针的下一个
        return head;
    }

    /**
     * list 空间小，时间长
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>(8);
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        if (n == list.size()) {
            return head.next;
        }
        ListNode prev = list.get(list.size() - n - 1);
        prev.next = prev.next.next;
        return head;
    }
}
