package q00234s;

import tool.ListNode;

import java.util.LinkedList;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome ip = new IsPalindrome();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(2);
        System.out.println(l1);
        System.out.println(ip.isPalindrome(l1));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, high = head;
        int h = 1;
        LinkedList<Integer> list = new LinkedList<>();
        while (high != null) {
            if (h % 2 == 0) {
                list.addFirst(slow.val);
                slow = slow.next;
            }
            h++;
            high = high.next;
        }
        if (h % 2 == 0) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != list.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        ListNode daeh = new ListNode(0);
        ListNode slow = head, high = head;
        int m = 0, h = 1;
        while (high != null) {
            if (h/2 == m + 1) {
                ListNode next = daeh.next;
                ListNode curr = new ListNode(slow.val);
                if (next != null) {
                    curr.next = next;
                }
                daeh.next = curr;
                slow = slow.next;
                m++;
            }
            h++;
            high = high.next;
        }
        daeh = daeh.next;
        if (h > 2 * m + 1) {
            slow = slow.next;
        }
        while (m > 0) {
            if (slow.val != daeh.val) {
                return false;
            }
            slow = slow.next;
            daeh = daeh.next;
            m--;
        }
        return true;
    }
}
