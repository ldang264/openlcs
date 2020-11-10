package q01325m;

import tool.TreeNode;

public class RemoveLeafNodes {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null || dfs(root, target)) return null;
        return root;
    }

    /**
     * 深度优先遍历
     * @param root
     */
    private boolean dfs(TreeNode root, int target) {
        boolean find1, find2;
        if (root.left != null) {
            if (find1 = dfs(root.left, target)) { // 如果子递归符合，则将left置为空
                root.left = null;
            }
        } else find1 = true;
        if (root.right != null) {
            if (find2 = dfs(root.right, target)) { // 如果子递归符合，则将right置为空
                root.right = null;
            }
        } else find2 = true;
        return find1 && find2 && root.val == target;
    }
}
