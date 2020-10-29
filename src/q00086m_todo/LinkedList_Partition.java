package q00086m_todo;

import tool.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedList_Partition {
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 1.找到第一个>=x的节点t
     * 2.将之后所有<x的节点以此插入到节点t之前
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode opt = new ListNode(0);
        opt.next = head;
        ListNode curr = opt, t = null;
        while (curr.next != null) {
            if (curr.next.val >= x) {
                t = curr; // 找到插入点
                break;
            }
            curr = curr.next;
        }
        while (curr.next != null) {
            if (curr.next.val < x) { // 凡是小于x的，都放到t后面，再赋值给t
                ListNode cn = curr.next;
                curr.next = cn.next;
                ListNode tn = t.next;
                cn.next = tn;
                t.next = cn;
                t = cn;
            } else
                curr = curr.next;
        }
        return opt.next;
    }

    private static void test1() {
        LinkedList_Partition p = new LinkedList_Partition();
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        System.out.println(p.partition(head, 3));
    }

    private static void test2() {
        LinkedList_Partition p = new LinkedList_Partition();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println(p.partition(head, 3));
    }
}
