import tool.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 示例 1：
 * 输入:
 *   5
 *  /  \
 * 2   -3
 * 返回[2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例2：
 * 输入：
 *    5
 *  /  \
 * 2   -5
 * 返回[2]，只有 2 出现两次，-5 只出现 1 次。
 *
 * 提示：假设任意子树元素和均可以用 32 位有符号整数表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00508m {

    private Map<Integer, Integer> map;

    private int max;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        map = new HashMap<>();
        max = 1;
        getSum(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) { // 等于最大次数的加入到list
                list.add(entry.getKey());
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * 深度优先+二叉树的后序遍历
     * @param root
     * @return
     */
    private int getSum(TreeNode root) {
        int sum = root.val;
        if (root.left != null) {
            sum += getSum(root.left);
        }
        if (root.right != null) {
            sum += getSum(root.right);
        }
        Integer count = map.get(sum);
        if (count == null) {
            count = 1;
        } else {
            count++;
            if (count > max) max = count; // 记录下出现的最大次数
        }
        map.put(sum, count);
        return sum;
    }
}
