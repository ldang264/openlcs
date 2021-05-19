import tool.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00024m {

    public static void main(String[] args) {
        Q00024m sp = new Q00024m();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        //l1.next.next.next = new ListNode(4);
        System.out.println(l1);
        System.out.println(sp.swapPairs(l1));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head; // 0或1个节点无须处理
        ListNode hair = new ListNode(0), prev = hair;
        hair.next = head;
        while (prev.next != null && prev.next.next != null) { // 确保剩余还有两个节点可翻转
            ListNode pn = prev.next;
            ListNode pnn = pn.next;
            prev.next = pnn;
            pn.next = pnn.next;
            pnn.next = pn;
            prev = pn;
        }
        return hair.next;
    }
}
