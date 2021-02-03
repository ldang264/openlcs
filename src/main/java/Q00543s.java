import tool.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00543s {
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int l = 0, r = 0;
        if (root.left != null) {
            l = dfs(root.left) + 1; // 左子树的最大深度
        }
        if (root.right != null) { // 右子树的最大深度
            r = dfs(root.right) + 1;
        }
        ans = Math.max(ans, l + r); // 计算最大直径，即左右相加
        return Math.max(l ,r); // 返回最大深度
    }
}
