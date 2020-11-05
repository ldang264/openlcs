package q00112s;

import tool.TreeNode;

public class BT_HasPathSum {
    private boolean res;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        dfs(root, sum, 0);
        return res;
    }

    /**
     * 深度优先
     * @return
     */
    private void dfs(TreeNode root, int sum, int now) {
        if (res) {
            return;
        }
        int n = now + root.val;
        if (root.left == null && root.right == null && n == sum) res = true; // 叶子节点且相等
        else {
            if (root.left != null) dfs(root.left, sum, n);
            if (root.right != null) dfs(root.right, sum, n);
        }
    }
}
