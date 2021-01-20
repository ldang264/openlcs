import tool.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00110s {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Q00110s btib = new Q00110s();
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        TreeNode right1 = new TreeNode(20);
        right1.left = left2;
        right1.right = right2;
        TreeNode left1 = new TreeNode(9);
        TreeNode root = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        System.out.println(btib.isBalanced(root));
    }

    private static void test2() {
        Q00110s btib = new Q00110s();
        TreeNode left3 = new TreeNode(4);
        TreeNode right3 = new TreeNode(4);
        TreeNode left2 = new TreeNode(3);
        left2.left = left3;
        left2.right = right3;
        TreeNode right2 = new TreeNode(3);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        left1.left = left2;
        left1.right = right2;
        TreeNode root = new TreeNode(1);
        root.left = left1;
        root.right = right1;
        System.out.println(btib.isBalanced(root));
    }

    private static void test3() {
        Q00110s btib = new Q00110s();
        TreeNode left3 = new TreeNode(4);
        TreeNode right3 = new TreeNode(4);
        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(3);
        left2.left = left3;
        right2.right = right3;
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        left1.left = left2;
        right1.right = right2;
        TreeNode root = new TreeNode(1);
        root.left = left1;
        root.right = right1;
        System.out.println(btib.isBalanced(root));
    }

    private int ans;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        loop(root);
        return ans <= 1;
    }

    public int loop(TreeNode node) {
        if (ans > 1) {
            return ans;
        }
        if (node == null) {
            return 0;
        }
        int leftDegree = loop(node.left) + 1;
        int rightDegree = loop(node.right) + 1;
        if (leftDegree > rightDegree) {
            int sub = leftDegree - rightDegree;
            if (sub > 1) {
                ans = sub;
            }
            return leftDegree;
        } else {
            int sub = rightDegree - leftDegree;
            if (sub > 1) {
                ans = sub;
            }
            return rightDegree;
        }
    }
}
