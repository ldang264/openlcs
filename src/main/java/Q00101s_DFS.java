import tool.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00101s_DFS {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right); // 递归左右子树
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        return (left == null && right == null) || // 均为空
                (left != null && right != null && left.val == right.val // 不为空，值相等且左左+右右和左右+右左均对称
                        && dfs(left.left, right.right) && dfs(left.right, right.left));

    }
}
