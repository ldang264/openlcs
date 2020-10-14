package q00530;

import tool.TreeNode;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 作者：LeetCode-Solution
 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/solution/er-cha-sou-suo-shu-de-zui-xiao-jue-dui-chai-by-lee/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class BST_MinimumDifference_MediumOrder {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        BST_MinimumDifference_MediumOrder md = new BST_MinimumDifference_MediumOrder();
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(7);
        root.right = t2;
        root.left = t1;
        System.out.println(md.getMinimumDifference(root));
    }

    public static void test1() {
        BST_MinimumDifference_MediumOrder md = new BST_MinimumDifference_MediumOrder();
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(6);
        root.right = t1;
        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t4.left = t5;
        System.out.println(md.getMinimumDifference(root));
    }
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}
