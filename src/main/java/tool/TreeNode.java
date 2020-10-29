package tool;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" " + val);
        if (left != null) {
            sb.append(" " + left.toString());
        }
        if (right != null) {
            sb.append(" " + right.toString());
        }
        return sb.toString();
    }
}
