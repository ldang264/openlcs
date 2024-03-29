import tool.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 输入：(4 -> 3) + (5 -> 6 -> 4)
 * 输出：9 -> 9 -> 4
 * 原因：34 + 465 = 499
 *
 * 输入：(3) + (5 -> 6 -> 4)
 * 输出：8 -> 6 -> 4
 * 原因：3 + 465 = 468
 *
 * 输入：(6) + (5 -> 6 -> 4)
 * 输出：1 -> 7 -> 4
 * 原因：6 + 465 = 471
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00002m {

    public static void main(String[] args) {
        Q00002m atn = new Q00002m();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        /*l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(1);*/
        System.out.println("l1:" + l1);

        ListNode l2 = new ListNode(1);
        /*l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);*/
        System.out.println("l2:" + l2);

        ListNode listNode = atn.addTwoNumbers(l1, l2);
        System.out.println("result:" + listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode hair = new ListNode(0), prev = hair;
        hair.next = l1;
        int jw = 0;
        // 7 -> 1     2 -> 1
        // 5 -> 9 -> 2
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + jw; // 节点值+进位
            if (num >= 10) {
                jw = 1;
                l1.val = num - 10;
            } else {
                jw = 0;
                l1.val = num;
            }
            prev = l1; // prev一直在l1之前一个节点
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) { // l2不为空时加入到l1的尾部
            l1 = prev.next = l2;
        }
        while (l1 != null) { // 将多余的处理完
            int num = l1.val + jw;
            if (num >= 10) {
                jw = 1;
                l1.val = num - 10;
            } else {
                jw = 0;
                l1.val = num;
            }
            prev = l1;
            l1 = l1.next;
        }
        if (jw > 0) { // 新增一个尾节点存放最后的进位
            prev.next = new ListNode(jw);
        }
        return hair.next;
    }

}
