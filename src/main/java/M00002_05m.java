import tool.ListNode;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * 示例：
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 示例：
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00002_05m {
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
