import tool.TreeNode;

/**
 * 给定一个二叉树，你需要找出二叉树中最长的连续序列路径的长度。
 * 请注意，该路径可以是递增的或者是递减。例如，[1,2,3,4] 和 [4,3,2,1] 都被认为是合法的，而路径 [1,2,4,3] 则不合法。另一方面，路径可以是 子-父-子 顺序，并不一定是 父-子 顺序。
 *
 * 示例 1:
 *
 * 输入:
 *         1
 *        / \
 *       2   3
 * 输出: 2
 * 解释: 最长的连续路径是 [1, 2] 或者 [2, 1]。
 *
 * 示例 2:
 * 输入:
 *         2
 *        / \
 *       1   3
 * 输出: 3
 * 解释: 最长的连续路径是 [1, 2, 3] 或者 [3, 2, 1]。
 *
 * 注意: 树上所有节点的值都在 [-1e7, 1e7] 范围内。
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -3 * 104 <= Node.val <= 3 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00549m {
    private int ans;

    public int longestConsecutive(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    /**
     * 深度优先-先序遍历
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root != null) {
            // 1.尝试左小右大
            int min = findMin(root.left, root.val); // 左子树找小的
            int max = findMax(root.right, root.val); // 右子树找大的
            ans = Math.max(ans, max - min + 1); // 连续序列的长度
            // 2.尝试左大右小
            min = findMin(root.right, root.val); // 左子树找大的
            max = findMax(root.left, root.val); // 右子树找小的
            ans = Math.max(ans, max - min + 1); // 连续序列的长度
            dfs(root.left); // 遍历左子树
            dfs(root.right); // 遍历右子树
        }
    }

    /**
     * 找能够连续下探的最小值
     * @param root
     * @param p
     * @return
     */
    private int findMin(TreeNode root, int p) {
        if (root == null || root.val != p - 1) return p;
        return Math.min(findMin(root.left, root.val), findMin(root.right, root.val));
    }

    /**
     * 找能够连续下探的最大值
     * @param root
     * @param p
     * @return
     */
    private int findMax(TreeNode root, int p) {
        if (root == null || root.val != p + 1) return p;
        return Math.max(findMax(root.left, root.val), findMax(root.right, root.val));
    }
}
