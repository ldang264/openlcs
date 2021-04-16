import tool.TreeNode;

/**
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00004_04s {

    private boolean flag;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        flag = true;
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && flag;
    }

    private int getDepth(TreeNode root) {
        if (!flag || root == null) return 0; // 终止递归
        int leftDepth = getDepth(root.left); // 左子树的高
        int rightDepth = getDepth(root.right); // 右子树的高
        if (Math.abs(leftDepth - rightDepth) > 1) { // 子树不是平衡树
            flag = false;
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1; // 返回树高
    }
}
