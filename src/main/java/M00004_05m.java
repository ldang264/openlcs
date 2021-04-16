import tool.TreeNode;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *     / \
 *    3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *     根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00004_05m {

    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true; // 空返回true
        if (!isValidBST(root.left) || (prev != null && prev.val >= root.val)) return false; // 左子树不满足或者当前节点不小于前一个引用的值，返回false
        prev = root; // 更新前一个引用
        return isValidBST(root.right); // 判断右子树
    }
}
