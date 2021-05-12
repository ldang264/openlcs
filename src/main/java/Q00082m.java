import tool.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00082m {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode hair = new ListNode(0), prev = hair, curr = head;
        hair.next = head;
        while (curr != null && curr.next != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next; // 一直向后遍历
            }
            if (prev.next == curr) { // 没有相等情况，正常遍历
                prev = curr;
            } else {
                prev.next = curr.next; // 中间删除
            }
            curr = curr.next;
        }
        return hair.next;
    }
}
