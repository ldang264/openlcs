import tool.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 * 提示：
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00142m {
    public ListNode detectCycle(ListNode head) {
        // 采用快慢指针，快指针fast每次走两步，慢指针slow每次走一步，如果有环，它们必相遇
        // 设出发点到环口长度为a，环口到交点长度为b,交点到环口长度为c，假设fast走了m圈环,slow走了n圈环，则有如下等式
        // a + m(b + c) + b = 2 (a + n(b + c) + b)
        // a + b = (m - 2n)(b + c)
        // a = (m - 2n - 1)(b + c) + c
        // 则如果另一个指针再走a的距离，一定把c给填上，它们在环口相遇
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) { // 有环，且相遇
                if (slow == head) return slow;
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
