package j00024s;

import tool.ListNode;

/**
 *定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList {
    public static void main(String[] args) {
        ReverseList rl = new ReverseList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(l1);
        System.out.println(rl.reverseList(l1));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode ans = new ListNode(0);
        while (head != null) {
            ListNode curr = new ListNode(head.val);
            ListNode prev = ans.next;
            if (prev != null) {
                curr.next = prev;
            }
            ans.next = curr;
            head = head.next;
        }
        return ans.next;
    }
}
