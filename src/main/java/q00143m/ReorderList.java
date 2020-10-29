package q00143m;

import tool.ListNode;

import java.util.LinkedList;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList {

    public static void main(String[] args) {
        ReorderList rl = new ReorderList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        System.out.println("l1-  " + l1);
        rl.reorderList(l1);
        System.out.println("l1+  " + l1);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        l2.next.next.next.next = new ListNode(5);
        System.out.println("l2-  " + l2);
        rl.reorderList(l2);
        System.out.println("l2+  " + l2);
    }

    public void reorderList(ListNode head) {
        if (head == null) return;
        LinkedList<ListNode> nodes = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            nodes.offer(curr);
            curr = curr.next;
        }
        ListNode t = null;
        while (true) {
            ListNode h = nodes.removeFirst();
            if (t != null){
                t.next = h;
            }
            if (nodes.size() == 0) {
                h.next = null;
                return;
            }
            t = nodes.removeLast();
            h.next = t;
            if (nodes.size() == 0) {
                t.next = null;
                return;
            }
        }
    }
}
