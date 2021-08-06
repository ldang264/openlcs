import tool.ListNode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00143m {

    // 1 2 3       f = 2
    // 1 2 3 4     f = 2
    // 1 2 3 4 5   f = 3
    public void reorderList(ListNode head) {
        // 1.使用快慢指针获取后半部分
        if (head.next == null || head.next.next == null) return;
        ListNode first = head, second = head.next;
        while (second != null && second.next != null) {
            second = second.next.next;
            first = first.next;
        }
        // 2.翻转后半部分
        second = first.next;
        while (second.next != null) {
            ListNode fn = first.next;
            ListNode cn = second.next;
            second.next = second.next.next;
            first.next = cn;
            cn.next = fn;
        }
        // 3.断开前后联系
        second = first.next;
        first.next = null;
        first = head;
        // 4.将后半部分插入到前半部分
        while (second != null) {
            ListNode fn = first.next;
            ListNode sn = second.next;
            first.next = second;
            first = second.next = fn;
            second = sn;
        }
    }

}
