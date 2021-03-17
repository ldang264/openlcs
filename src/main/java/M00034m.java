import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 示例:
 * 给定如下二叉树，以及目标和target = 22，
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
 * 提示：
 * 节点总数 <= 10000
 *
 * 注意：本题与主站 113题相同：https://leetcode-cn.com/problems/path-sum-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00034m {
    private List<List<Integer>> ans;
    private List<Integer> temp;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        if (root == null) return ans;
        temp = new ArrayList<>();
        dfs(root, target, 0);
        return ans;
    }

    private void dfs(TreeNode node, int target, int sum) {
        sum += node.val; // 加入当前节点的值
        int size = temp.size(); // 记录原列表长度
        temp.add(node.val); // 候选加入
        if (node.left == null && node.right == null) { // 考察叶子节点
            if (sum == target) { // 如果相等则加入到结果
                ans.add(new ArrayList<>(temp));
            }
        } else {
            if (node.left != null) {
                dfs(node.left, target, sum); // 遍历左子树
            }
            if (node.right != null){
                dfs(node.right, target, sum); // 遍历右子树
            }
        }
        temp.remove(size);
    }
}
