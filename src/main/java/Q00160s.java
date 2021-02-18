import tool.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如下面的两个链表：
 * 在节点 c1 开始相交。
 *
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 示例2：
 * 输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 示例3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 * 
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00160s {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currA = headA, currB = headB;
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
            if (currA == null && currB == null) return null; // 有可能无交点
            // 空的时候用对方的链表继续走
            if (currA == null) {
                currA = headB;
            } else if (currB == null) {
                currB = headA;
            }
        }
        return currA;
    }

    /* 计算各自长度，长的先走一段，一起走到交点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = getLen(headA);
        int lB = getLen(headB);
        int len;
        ListNode currA = headA;
        ListNode currB = headB;
        // 较长的链表先走len步
        if (lA > lB) {
            len = lA - lB;
            while (len-- > 0) {
                currA = currA.next;
            }
        } else if (lA < lB) {
            len = lB - lA;
            while (len-- > 0) {
                currB = currB.next;
            }
        }
        // 一起走，相等时为交点或null
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }

    *//**
     * 计算链表长度
     * @param listNode
     * @return
     *//*
    private int getLen(ListNode listNode) {
        int len = 0;
        ListNode curr = listNode;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
*/
    /* Hash集合，占有额外空间
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> aSet = new HashSet<>();
        while (headA != null) {
            aSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (aSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }*/
}
