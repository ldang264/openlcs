package q00101s;

import tool.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * <p>
 *
 * <p>例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * <p>1 / \ 2 2 / \ / \ 3 4 4 3
 *
 * <p>但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 * <p>1 / \ 2 2 \ \ 3 3
 *
 * <p>进阶：
 *
 * <p>你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 自己答案超时，参考官方
 * 深度优先搜索
 */
public class BT_IsSymmetric_DFS {

    private boolean ans;

    public boolean isSymmetric(TreeNode root) {
        ans = true;
        if (root == null) {
            return true;
        }
        if (root.left == null) return root.right == null;
        if (root.right == null) return false;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (!ans || left == null || right == null || left.val != right.val) {
            return false;
        }
        if (left.left != null && right.right != null) {
            ans = dfs(left.left, right.right);
        }
        if (!ans) return false;
        if (left.right != null && right.left != null) {
            ans = dfs(left.right, right.left);
        }
        return ans;
    }
}
