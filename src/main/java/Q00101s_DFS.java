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
public class Q00101s_DFS {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    public boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}
