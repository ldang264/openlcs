import tool.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00023h {

    public static void main(String[] args) {
        Q00023h mkl = new Q00023h();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        System.out.println(mkl.mergeKLists(new ListNode[]{l1, l2, l3}));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergerRange(lists, 0, lists.length - 1);
    }

    /**
     * 归并排序
     * @param lists
     * @param left
     * @param right
     * @return
     */
    private ListNode mergerRange(ListNode[] lists, int left, int right) {
        if (left >= right) return lists[left];
        int mid = (left + right) >> 1;
        ListNode ls = mergerRange(lists, left, mid);
        ListNode rs = mergerRange(lists, mid + 1, right);
        return mergeTwo(ls, rs);
    }

    /**
     * 递归合并
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwo(l1, l2.next);
        return l2;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 分治
     * @param lists
     * @param start
     * @param end
     * @return
     */
    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];
        int mid = (start + end) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode hair = new ListNode(-1);
        ListNode curr = hair;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        if (node1 != null) {
            curr.next = node1;
        } else {
            curr.next = node2;
        }
        return hair.next;
    }
}
