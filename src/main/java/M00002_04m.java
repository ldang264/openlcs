import tool.ListNode;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00002_04m {
    public ListNode partition(ListNode head, int x) {
        // 找到一个大于x的基准值，小于x的节点，往它前面放，等于x的节点，往它后面放
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode prev = hair, curr = head, little = hair;
        while (curr != null) {
            if (curr.val == x) {
                prev = curr;
                curr = curr.next;
            } else { // 不是x的放在little后面
                ListNode cn = curr.next;
                ListNode ln = little.next;
                if (ln != curr) {
                    little.next = curr;
                    curr.next = ln;
                    prev.next = cn;
                } else {
                    prev = curr;
                }
                if (curr.val < x) { // 小于x的要更新
                    little = curr;
                }
                curr = cn;
            }
        }
        return hair.next;
    }

    // 逻辑过于复杂了
    public ListNode partition1(ListNode head, int x) {
        // 小于x的节点，往hair后面放，大于等于x的节点，往最接近x节点的前面放
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode prev = hair, curr = head, XPrevNode = null, XNode = null;
        while (curr != null) {
            if (curr.val < x) {
                if (curr != hair.next) {
                    ListNode cn = curr.next;
                    ListNode hn = hair.next;
                    hair.next = curr;
                    curr.next = hn;
                    prev.next = cn;
                    curr = cn;
                    if (XPrevNode == hair) XPrevNode = XPrevNode.next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            } else if (curr.val > x) {
                if (XNode != null) {
                    prev.next = prev.next.next;
                    XPrevNode.next = curr;
                    curr.next = XNode;
                    XPrevNode = curr;
                    curr = prev.next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            } else if (XNode == null){
                XPrevNode = prev;
                XNode = curr;
                prev = curr;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return hair.next;
    }
}
