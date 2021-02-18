import tool.TreeNode;

public class Q01038m /*同538*/{
    private int sum;

    /**
     * 深度优先搜索-先右后左中序遍历
     * @param root
     * @return
     */
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            root.val += sum; // 当前节点加上前一个遍历结束的和
            sum = root.val; // 更新和
            bstToGst(root.left);
        }
        return root;
    }
}
