import tool.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *     / \
 *    3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 作者：LeetCode-Solution
 链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q00098m_LowerUpper {

    public static void main(String[] args) {
        Q00098m_LowerUpper bstV = new Q00098m_LowerUpper();

        TreeNode root1 = new TreeNode(2);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(3);
        root1.left = l1;
        root1.right = r1;
        System.out.println(bstV.isValidBST(root1));

        TreeNode root2 = new TreeNode(5);
        TreeNode l11 = new TreeNode(1);
        TreeNode r11 = new TreeNode(4);
        root2.left = l11;
        root2.right = r11;
        TreeNode l21 = new TreeNode(3);
        TreeNode r21 = new TreeNode(6);
        r11.left = l21;
        r11.right = r21;
        System.out.println(bstV.isValidBST(root2));

        TreeNode root3 = new TreeNode(10);
        TreeNode l31 = new TreeNode(5);
        TreeNode r31 = new TreeNode(15);
        root3.left = l31;
        root3.right = r31;
        TreeNode l32 = new TreeNode(6);
        TreeNode r32 = new TreeNode(20);
        r31.left = l32;
        r31.right = r32;
        System.out.println(bstV.isValidBST(root3));

        TreeNode root4 = new TreeNode(1);
        TreeNode l41 = new TreeNode(1);
        root4.left = l41;
        System.out.println(bstV.isValidBST(root4));
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

}
