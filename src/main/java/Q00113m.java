import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *
 * 提示：
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00113m {
    private List<List<Integer>> ans;
    private List<Integer> temp;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        if (root == null) return ans;
        temp = new ArrayList<>();
        dfs(root, targetSum);
        return ans;
    }

    private void dfs(TreeNode node, int target) {
        target -= node.val; // 加入当前节点的值
        int size = temp.size(); // 记录原列表长度
        temp.add(node.val); // 候选加入
        if (node.left == null && node.right == null) { // 考察叶子节点
            if (0 == target) { // 如果相等则加入到结果
                ans.add(new ArrayList<>(temp));
            }
        } else {
            if (node.left != null) {
                dfs(node.left, target); // 遍历左子树
            }
            if (node.right != null){
                dfs(node.right, target); // 遍历右子树
            }
        }
        temp.remove(size);
    }
}
