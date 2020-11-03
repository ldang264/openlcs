package q00206s;

import tool.ListNode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ListNode_ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode op = new ListNode(0);
        op.next = head;
        ListNode curr = head;
        while (curr.next != null) {
            ListNode next = curr.next;
            ListNode nn = next.next;
            op.next = next;
            next.next = curr;
            curr.next = nn;
        }
        return op.next;
    }
}
