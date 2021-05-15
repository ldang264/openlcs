import tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 *
 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点。
 *
 * 示例 1：
 * 输入：root = [2,1,3], p = 1
 * 输出：2
 * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 *
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], p = 6
 * 输出：null
 * 解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
 *  
 *
 * 提示：
 * 树中节点的数目在范围 [1, 104] 内。
 * -105 <= Node.val <= 105
 * 树中各节点的值均保证唯一。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/inorder-successor-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00285m {

    private TreeNode prev;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root.val > p.val) { // 在左子树上
            prev = root; // prev一直变小，它是比目标节点右子树大一点的节点
            return inorderSuccessor(root.left, p);
        }
        if (root.val < p.val) return inorderSuccessor(root.right, p); // 在右子树上
        return root.right == null ? prev : dfs(root.right); // 无右子树，返回prev；递归右子树，找最左节点
    }

    private TreeNode dfs(TreeNode node) {
        return node.left == null ? node : dfs(node.left); // 有左子树则一直递归，否则返回最左节点
    }

    /**
     * 迭代
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessorRecursive(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new LinkedList<>();
        boolean find = false;
        while (stack.size() > 0 || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (find) return root;
            if (root == p) {
                find = true;
            }
            root = root.right;
        }
        return null;
    }
}
