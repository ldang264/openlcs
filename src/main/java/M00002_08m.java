import tool.ListNode;

/**
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00002_08m {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        // 快慢指针,快指针走两步，慢指针走一步
        // 设头到环口距离为a，环口到交点距离为b和c，数学证明如下
        //    a + m(b + c) + b = 2(a + n(b + c) + b)
        // => a + m(b + c) + b = 2a + 2n(b + c) + 2b
        // => (m - 2n)(b + c) = a + b
        // => a = (m - 2n - 1)(b + c) + c
        // 故，头到环口的距离就是k圈+c，因此接下来从头再走a这么长，刚好走k圈且把c走掉，在环口相遇
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) fast = fast.next;
            slow = slow.next;
            if (fast == slow) { // 相遇了
                while (slow != null) { // slow空肯定没交点
                    if (head == slow) return head;
                    head = head.next;
                    slow = slow.next;
                }
            }
        }
        return null; // fast正常走完，无交点
    }
}
