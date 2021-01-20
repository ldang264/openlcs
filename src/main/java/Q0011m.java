import tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明:叶子节点是指没有子节点的节点。
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
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q0011m {
    private List<List<Integer>> ansLists;
    private LinkedList<Integer> candidateList;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ansLists = new ArrayList<>();
        if (root == null) return ansLists;
        candidateList = new LinkedList<>();
        dfs(root, sum, 0);
        return ansLists;
    }

    /**
     * 深度优先搜索
     */
    private void dfs(TreeNode root, int sum, int now) {
        int n = now + root.val;
        candidateList.addLast(root.val);
        if (root.left == null && root.right == null && n == sum) {
            ansLists.add(new LinkedList<>(candidateList));
        } else {
            if (root.left != null) {
                dfs(root.left, sum, n);
                candidateList.removeLast();
            }
            if (root.right != null) {
                dfs(root.right, sum, n);
                candidateList.removeLast();
            }
        }
    }
}
