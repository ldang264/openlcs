import tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * 3
 * 解释：和为 22的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 *
 * 提示：
 * 节点总数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00004_12m {

    private int ans;

    /**
     * 每个节点进行递归
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root != null) {
            dfs(root, sum);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
        }
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) ans++;
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    /**
     * 前缀和
     * @param root
     * @param sum
     * @return
     */
    public int pathSumAns(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, map, sum, 0);
    }

    private int helper(TreeNode node, Map<Integer, Integer> map, int sum, int curSum) {
        if (node == null) {
            return 0;
        }
        curSum += node.val;
        int count = map.getOrDefault(curSum - sum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        count += helper(node.left, map, sum, curSum);
        count += helper(node.right, map, sum, curSum);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
        return count;
    }

}
