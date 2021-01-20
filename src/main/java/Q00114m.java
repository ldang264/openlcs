import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00114m {
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        TreeNode cr = root;
        for (int i = 1; i < list.size(); i++) {
            cr.left = null;
            cr.right = new TreeNode(list.get(i));
            cr = cr.right;
        }
    }

    /**
     * 深度优先搜索-前序
     */
    private void dfs(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if (node.left != null) dfs(node.left, list);
        if (node.right != null) dfs(node.right, list);
    }
}
