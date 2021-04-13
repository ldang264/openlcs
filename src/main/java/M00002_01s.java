import tool.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 *
 * 示例2:
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 *
 * 提示：
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 *
 * 进阶：
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00002_01s {

    /**
     * 可以只使用一个引用完成操作
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while (curr.next != null) {
            if (!set.add(curr.next.val)) { // 重复将返回false
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head, curr = head.next;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while (curr != null) {
            if (!set.add(curr.val)) { // 重复将返回false
                curr = prev.next = prev.next.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
