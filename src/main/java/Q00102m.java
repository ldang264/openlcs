import tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00102m {
    public static void main(String[] args) {
        Q00102m lo = new Q00102m();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        t1.left = t2;
        TreeNode t3 = new TreeNode(20);
        t1.right = t3;
        TreeNode t4 = new TreeNode(15);
        t3.left = t4;
        TreeNode t5 = new TreeNode(7);
        t3.right = t5;
        System.out.println(lo.levelOrder(t1));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (list.size() > 0) {
            int size = list.size();
            List<Integer> row = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode node = list.pop();
                row.add(node.val);
                if(node.left != null) {
                    list.add(node.left);
                }
                if(node.right != null) {
                    list.add(node.right);
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
