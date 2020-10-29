package q00103m;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        ZigzagLevelOrder zlo = new ZigzagLevelOrder();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        t1.left = t2;
        TreeNode t3 = new TreeNode(20);
        t1.right = t3;
        TreeNode t4 = new TreeNode(15);
        t3.left = t4;
        TreeNode t5 = new TreeNode(7);
        t3.right = t5;
        System.out.println(zlo.zigzagLevelOrder(t1));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean reverse = false;
        while (list.size() > 0) {
            int size = list.size();
            ArrayList<Integer> row = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode node = list.pop();
                if (reverse) {
                    row.add(0, node.val);
                } else {
                    row.add(node.val);
                }
                if(node.left != null) {
                    list.add(node.left);
                }
                if(node.right != null) {
                    list.add(node.right);
                }
            }
            reverse = !reverse;
            ans.add(row);
        }
        return ans;
    }
}
