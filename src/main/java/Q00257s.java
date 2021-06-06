import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00257s {
    private List<String> ans;

    private List<Integer> temp;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        temp.add(root.val);
        if (root.left != null || root.right != null) {
            dfs(root.left);
            dfs(root.right);
        } else { // 叶子节点
            StringBuilder sb = new StringBuilder();
            sb.append(temp.get(0));
            for (int i = 1; i < temp.size(); i++) {
                sb.append("->").append(temp.get(i));
            }
            ans.add(sb.toString());
        }
        temp.remove(temp.size() - 1);
    }
}
