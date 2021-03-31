package ans;

import tool.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00543s_Ans {
    int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        return depth(root);
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMaxDepth = depth(node.left);
        int rightMaxDepth = depth(node.right);
        maxDepth = Math.max(leftMaxDepth + rightMaxDepth, maxDepth); //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(leftMaxDepth, rightMaxDepth) + 1; //返回节点深度
    }
}
