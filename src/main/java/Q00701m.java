import tool.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 *  
 *
 * 例如, 
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00701m {

    public static void main(String[] args) {
        TreeNode left3 = new TreeNode(1);
        TreeNode right3 = new TreeNode(3);
        TreeNode left2 = new TreeNode(2, left3, right3);
        TreeNode right2 = new TreeNode(7);
        TreeNode root = new TreeNode(4, left2, right2);
        Q00701m iBST = new Q00701m();
        TreeNode treeNode = iBST.insertIntoBST(root, 5);
        System.out.println(treeNode);
    }

    public TreeNode insertIntoBST_0(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while (pos != null) {
            if (val < pos.val) {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    break;
                } else {
                    pos = pos.left;
                }
            } else {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        build(root, val);
        return root;
    }

    private void build (TreeNode root, int val) {
        if (root.val > val) { // 在左子树上找
            TreeNode left1 = root.left;
            if (left1 == null) {
                root.left = new TreeNode(val);
            } else { // 继续找
                build(left1, val);
            }
        } else { // 在右子树上找
            TreeNode right1 = root.right;
            if (right1 == null) {
                root.right = new TreeNode(val);
            } else { // 继续找
                build(right1, val);
            }
        }
    }

}
