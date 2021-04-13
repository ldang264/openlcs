import tool.TreeNode;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00530s {

    private int prev;

    private int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = 100000; // 最大就这么大
        prev = -100000; // 最小就这么小
        dfs(root);
        return ans;
    }

    /**
     * 中序遍历
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            ans = Math.min(ans, root.val - prev); // 取差值较小的
            prev = root.val;
            dfs(root.right);
        }
    }
}
