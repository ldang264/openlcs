import tool.TreeNode;

import java.util.LinkedList;

/**
 *给定一个二叉树，它的每个结点都存放一个0-9的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 * / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00129m {

    private int ans;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) return;
        sum = sum * 10 + node.val; // 先计算出到当前节点的数值
        if (node.left != null || node.right != null) {
            dfs(node.left, sum);
            dfs(node.right, sum);
        } else { // 无子节点，则结果加上之
            ans += sum;
        }
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public int sumNumbers1(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int ans = 0;
        while (list.size() > 0) {
            int size = list.size();
            while (size-- > 0) {
                TreeNode node = list.pop();
                if (node.left == null && node.right == null) { // 无子节点，则结果加上之
                    ans += node.val;
                }else {
                    int sum = node.val * 10;
                    if (node.left != null) {
                        node.left.val = sum + node.left.val;
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        node.right.val = sum + node.right.val;
                        list.add(node.right);
                    }
                }
            }
        }
        return ans;
    }
}
