package q00104;

import tool.TreeNode;

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
public class BT_MaxDepth_Answer {

    public static void main(String[] args) {
        //test();
        //test1();
        test2();
    }

    public static void test() {
        BT_MaxDepth_Answer btMaxDepth = new BT_MaxDepth_Answer();
        TreeNode left1 = new TreeNode(9);
        TreeNode root = new TreeNode(3);
        root.left = left1;
        System.out.println(btMaxDepth.maxDepth(root));
    }

    public static void test1() {
        BT_MaxDepth_Answer btMaxDepth = new BT_MaxDepth_Answer();
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

    public static void test2() {
        BT_MaxDepth_Answer btMaxDepth = new BT_MaxDepth_Answer();
        TreeNode left2 = new TreeNode(15);
        TreeNode right1 = new TreeNode(20);
        right1.left = left2;
        TreeNode left1 = new TreeNode(9);
        TreeNode root = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        System.out.println(btMaxDepth.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
