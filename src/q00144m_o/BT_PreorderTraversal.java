package q00144m_o;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BT_PreorderTraversal {
    public static void main(String[] args) {
        BT_PreorderTraversal pt = new BT_PreorderTraversal();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.right = t2;
        TreeNode t3 = new TreeNode(3);
        t2.left = t3;
        System.out.println(pt.preorderTraversal(t1));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        List<Integer> list = new ArrayList<>();
        dfs_preorder(root, list);
        return list;
    }

    private void dfs_preorder(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if (node.left != null) {
            dfs_preorder(node.left, list);
        }
        if (node.right != null) {
            dfs_preorder(node.right, list);
        }
    }
}
