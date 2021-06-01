import tool.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回它的前序遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00144s {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (stack.size() > 0) {
            root = stack.pop(); // 弹出根
            list.add(root.val);
            if (root.right != null) { // 加入右节点，先进后出
                stack.push(root.right);
            }
            if (root.left != null) { // 加入左节点，后进先出
                stack.push(root.left);
            }
        }
        return list;
    }
}
