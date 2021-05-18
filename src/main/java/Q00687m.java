import tool.TreeNode;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 * 2
 *
 * 示例 2:
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 * 2
 *
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00687m {

    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left); // 左子树以root.left.val连续的个数
        int right = dfs(root.right); // 右子树以root.right.val连续的个数
        int count1 = 0, count2 = 0;
        if (left > 0 && root.val == root.left.val) {
            count1 = left; // 与root相等，加上左子树的贡献
        }
        if (right > 0 && root.val == root.right.val) {
            count2 = right; // 与root相等，加上右子树的贡献
        }
        ans = Math.max(ans, count1 + count2); // 更新最大连续长度
        return 1 + Math.max(count1, count2); // 返回较长的长度+1
    }
}
