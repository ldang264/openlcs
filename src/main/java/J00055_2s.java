import tool.TreeNode;

public class J00055_2s {

    private boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return ans;
    }

    private int getDepth(TreeNode root) {
        if (root == null || !ans) return 0;
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if (Math.abs(ld - rd) > 1) {
            ans = false;
            return 0;
        }
        return Math.max(ld, rd) + 1;
    }
}
