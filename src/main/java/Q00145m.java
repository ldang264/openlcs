import tool.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回它的 后序遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00145m {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 后序遍历需要维护一个刚处理过的引用
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == prev) {
                stack.pop();
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return list;
    }
}
