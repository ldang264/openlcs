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
        if (head == null) return head;
        ListNode curr;
        boolean res = false;
        while (head.next != null) {
            if (head.val != head.next.val) {
                if (!res) {
                    break;
                }
                head = head.next;
                res = false;
            } else {
                res = true;
                head = head.next;
            }
        }
        if (res) {
            curr = head = head.next;
        } else {
            curr = head;
        }
        if (curr == null) return null;
        ListNode link = curr;
        boolean dup = false;
        while (curr.next != null) {
            if (curr.val != curr.next.val) {
                if (dup) {
                    link.next = curr.next;
                    dup = false;
                } else {
                    link = curr;
                }
            } else {
                dup = true;
            }
            curr = curr.next;
        }
        if (dup) {
            link.next = curr.next;
        }
        return head;
    }
}
