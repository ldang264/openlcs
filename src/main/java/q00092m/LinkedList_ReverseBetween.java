package q00092m;

import tool.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedList_ReverseBetween {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        boolean help = m == 1;
        ListNode opt;
        if (help) {// 如果m=1，表示从头开始翻，则引入一个辅助头节点，指向head，避免空指针
            opt = new ListNode(0);
            opt.next = head;
            m++;
            n++;
        } else {
            opt = head;
        }
        int i = 2; // 经过上述处理，肯定会从第二个节点往后开始翻
        ListNode start = opt;
        ListNode move = null;
        while (true) {
            if (i > m) {
                ListNode sn = start.next; // start后的那个节点
                ListNode mn = move.next; // 移动的那个节点的下一个节点，这个节点要翻到start后
                move.next = move.next.next; // 将移动的下一个节点跳过，让它翻到start后
                mn.next = sn; // 翻转的这个节点指向start的下一节点
                start.next = mn; // start的下一节点为翻转节点   --- 至此一次翻转完成
                if (i == n) {
                    return help ? opt.next : head; // i==n翻转结束，返回真实的那个head
                }
            } else if (i < m) {
                start = start.next; // 当i<m，一直往后移
            } else {
                move = start.next; // 当i=m时，找到第m个节点，它刚好每次往后移一位
            }
            i++;
        }
    }

    private static void test1() {
        LinkedList_ReverseBetween rb = new LinkedList_ReverseBetween();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(rb.reverseBetween(l1, 1, 1));
        System.out.println(rb.reverseBetween(l1, 5, 5));
        System.out.println(rb.reverseBetween(l1, 2, 4));
    }

    private static void test2() {
        LinkedList_ReverseBetween rb = new LinkedList_ReverseBetween();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(rb.reverseBetween(l1, 1, 5));
    }

    private static void test3() {
        LinkedList_ReverseBetween rb = new LinkedList_ReverseBetween();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(rb.reverseBetween(l1, 1, 4));
    }

    private static void test4() {
        LinkedList_ReverseBetween rb = new LinkedList_ReverseBetween();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(rb.reverseBetween(l1, 2, 5));
    }
}
