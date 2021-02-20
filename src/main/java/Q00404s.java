import tool.TreeNode;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00404s {

    private int ans;

    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) { // 左子树不为空但左子树的子树都为空，累加
                ans += root.left.val;
            } else { // 左子树还需要遍历
                dfs(root.left);
            }
        }
        dfs(root.right); // 右子树无论如何都要遍历一下
    }
}
