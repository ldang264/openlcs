import tool.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00083s {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head, temp;
        while (curr != null) {
            temp = curr;
            while (temp.next != null && temp.val == temp.next.val) {
                temp = temp.next;
            }
            if (temp != curr) curr.next = temp.next; // 将与curr值相同的断开
            curr = curr.next;
        }
        return head;
    }
}
