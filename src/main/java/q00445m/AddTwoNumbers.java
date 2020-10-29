package q00445m;

import tool.ListNode;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        System.out.println("l1:" + l1);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println("l2:" + l2);

        System.out.println(atn.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode l3 = new ListNode(0);

        ListNode c2 = l2;
        ListNode l4 = new ListNode(0);
        while (c1 != null) {
            ListNode t = new ListNode(c1.val);
            ListNode k = l3.next;
            if (k != null) {
                t.next = k;
            }
            l3.next = t;
            c1 = c1.next;
        }
        while (c2 != null) {
            ListNode t = new ListNode(c2.val);
            ListNode k = l4.next;
            if (k != null) {
                t.next = k;
            }
            l4.next = t;
            c2 = c2.next;
        }
        return add(l3.next, l4.next);
    }

    private ListNode add(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        boolean ten = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            ListNode t = new ListNode(0);
            ten = set(t, sum, ten);
            l1 = l1.next;
            l2 = l2.next;
            ListNode k = head.next;
            if (k != null) {
                t.next = k;
            }
            head.next = t;
        }
        while (l1 != null) {
            int sum = l1.val;
            ListNode t = new ListNode(0);
            ten = set(t, sum, ten);
            l1 = l1.next;
            ListNode k = head.next;
            if (k != null) {
                t.next = k;
            }
            head.next = t;
        }
        while (l2 != null) {
            int sum = l2.val;
            ListNode t = new ListNode(0);
            ten = set(t, sum, ten);
            l2 = l2.next;
            ListNode k = head.next;
            if (k != null) {
                t.next = k;
            }
            head.next = t;
        }
        if (ten) {
            ListNode t = new ListNode(1);
            ListNode k = head.next;
            if (k != null) {
                t.next = k;
            }
            head.next = t;
        }
        return head.next;
    }

    private boolean set (ListNode now, int sum, boolean ten) {
        if (ten) {
            if (sum < 9) {
                now.val = sum + 1; // 1,2,3,4,5,6,7,8,9
                ten = false;
            } else if (sum > 9) {
                now.val = sum - 9; // 0
            }
        } else {
            if (sum <= 9) {
                now.val = sum; // 0,1,2,3,4,5,6,7,8,9
            } else {
                now.val = sum - 10; // 0,1,2,3,4,5,6,7,8
                ten = true;
            }
        }
        return ten;
    }
}
