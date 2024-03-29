import tool.TreeNode;

/**
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第d层追加一行值为v的节点。
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为v的左子树和右子树。
 * 将N 原先的左子树，连接为新节点v 的左子树；将N 原先的右子树，连接为新节点v 的右子树。
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 *
 * 示例 1:
 * 输入: 
 * 二叉树如下所示:
 *        4
 *      /   \
 *     2     6
 *    / \   / 
 *   3   1 5   
 *
 * v = 1
 * d = 2
 *
 * 输出: 
 *        4
 *       / \
 *      1   1
 *     /     \
 *    2       6
 *   / \     / 
 *  3   1   5   
 *
 * 示例 2:
 * 输入: 
 * 二叉树如下所示:
 *       4
 *      /   
 *     2    
 *    / \   
 *   3   1    
 *
 * v = 1
 * d = 3
 *
 * 输出: 
 *       4
 *      /   
 *     2
 *    / \    
 *   1   1
 *  /     \  
 * 3       1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-one-row-to-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00632m {
    /**
     * 深度优先遍历
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        return dfs(root, v, d, 1);
    }

    private TreeNode dfs(TreeNode node, int v, int d, int cd) {
        if (node == null) return null;
        cd++;
        if (cd == d) {
            TreeNode nl = new TreeNode(v), nr = new TreeNode(v); // 新的左右子树
            nl.left = node.left;
            nr.right = node.right;
            node.left = nl;
            node.right = nr;
        } else {
            dfs(node.left, v, d, cd);
            dfs(node.right, v, d, cd);
        }
        return node;
    }
}
