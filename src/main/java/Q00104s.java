import tool.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00104s {

    /**
     * 深度优先
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int degree = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            while (size > 0) { // 该循环清空当前list，并将清出的每一个节点的左右子节点加入list
                TreeNode curr = list.poll();
                size--;
                if (curr.left != null) {
                    list.offer(curr.left);
                }
                if (curr.right != null) {
                    list.offer(curr.right);
                }
            }
            degree++; //清掉一层则+1
        }
        return degree;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public int maxDepthAns(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
