import tool.ListNode;
import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 提示:
 * The number of nodes in head is in the range [0, 2 * 104].
 * -10^5 <= Node.val <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00109m {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return loop(list, 0, list.size() - 1);
    }

    private TreeNode loop(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = loop(list, start, mid - 1);
        root.right = loop(list, mid + 1, end);
        return root;
    }

    // 答案：空间复杂度O（1）解法
    ListNode cur = null;
    public TreeNode sortedListToBSTAns(ListNode head) {
        if (head == null) return null;
        int len = 0;
        cur = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        return sortedListToBST(0, len - 1);
    }
    private TreeNode sortedListToBST(int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + (hi - lo >> 1);
        TreeNode left = sortedListToBST(lo, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        root.left = left;
        cur = cur.next;
        root.right = sortedListToBST(mid + 1, hi);
        return root;
    }
}
