import tool.TreeNode;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 *
 * 示例 1：
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 *
 * 示例 2：
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 *
 * 提示：
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00099h {

    private TreeNode node1, node2, prev;

    public void recoverTree(TreeNode root) {
        dfs(root);
        // 交换值
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    /**
     * 二叉搜索树的中序遍历是递增的
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (prev != null && prev.val > root.val) {
            node2 = root; // node2有可能是它相邻的，也可能在后面
            if (node1 != null) return;
            node1 = prev; // node1只会初始化一次
        }
        prev = root; // prev要不断更新
        dfs(root.right);
    }
}
