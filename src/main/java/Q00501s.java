import tool.TreeNode;

import java.util.*;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00501s {

    private List<Integer> list;

    private int prev, count, max;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        list = new ArrayList<>();
        count = max = 0;
        prev = -100001; // 数据范围之外的初始化值
        dfs(root);
        if (count > max) {
            return new int[]{ prev };
        }
        if (count == max) {
            list.add(prev);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (prev == root.val) {
            count++;
        } else {
            if (count == max) {
                list.add(prev);
            } else if (count > max) {
                list.clear();
                list.add(prev);
                max = count;
            }
            count = 1;
        }
        prev = root.val;
        dfs(root.right);
    }
}
