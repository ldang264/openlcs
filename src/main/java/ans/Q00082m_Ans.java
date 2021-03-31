package ans;

import tool.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 作者：MapleStore
 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/javadi-gui-0ms-by-maplestore/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q00082m_Ans {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) { // 特殊情况，头节点为null或头节点下一节点为null，直接返回头节点，这时不存在重复节点
            return head;
        }
        if (head.val == head.next.val) { // 如果头节点与头节点的下一节点值相等，跳过所有相等节点。递归调用函数判断最后一个跳过节点的后一节点
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else { // 如果头节点与，头节点的下一节点值不等，递归调用函数判断头节点的后一节点。
            head.next = deleteDuplicates(head.next);
            return head;
        }

    }
}
