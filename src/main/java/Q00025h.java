import tool.ListNode;

/**
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当k= 2 时，应当返回: 2->1->4->3->5
 * 当k= 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00025h {

    /**
     * 1ms 40%
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode newHead = new ListNode(0); // 操作节点
        newHead.next = head;
        ListNode op = newHead, handler = head, post = head;
        int i = 1;
        do {
            post = post.next;
            if (i == k) {
                // 开始反转
                while (i > 1) {
                    ListNode tail = op.next;
                    ListNode hn = handler.next;
                    ListNode hnn = hn.next;
                    op.next = hn;
                    hn.next = tail;
                    handler.next = hnn;
                    i--;
                }
                op = handler;
                handler = op.next;
            } else {
                i++;
            }
        } while (post != null);
        return newHead.next;
    }
}
