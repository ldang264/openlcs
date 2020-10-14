package q00104_todo;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BT_MaxDepth {

    public static void main(String[] args) {
        BT_MaxDepth btMaxDepth = new BT_MaxDepth();
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        TreeNode right1 = new TreeNode(20);
        right1.left = left2;
        right1.right = right2;
        TreeNode left1 = new TreeNode(9);
        TreeNode root = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        System.out.println(btMaxDepth.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null) {

        }
        List<Integer> list = new ArrayList<>();
        return findSub(root);
    }

    private int findSub(TreeNode sub) {
        int count = 0;
        if (sub.left == null && sub.right == null) {
            return 1;
        }
        if (sub.left != null) {
            count += findSub(sub.left);
        } else {
            count += findSub(sub.right);
        }
        return count;
    }
}
