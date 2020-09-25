package q00501;

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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMode {
    public static void main(String[] args) {
        FindMode fm = new FindMode();
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        root.right = t1;
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        int[] res = fm.findMode(root);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    /**
     * 将每一个值出现的次数存在map里
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> modes = new HashMap<>();
        find(root, modes);
        int key = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : modes.entrySet()) {
            if (entry.getValue() > max) {
                key = entry.getKey();
                max = entry.getValue();
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : modes.entrySet()) {
            if (max == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private void find(TreeNode left, Map<Integer, Integer> modes) {
        if (!modes.containsKey(left.val)) {
            modes.put(left.val, 1);
        } else {
            modes.put(left.val, modes.get(left.val) + 1);
        }
        if (left.left != null) {
            find(left.left, modes);
        }
        if (left.right != null) {
            find(left.right, modes);
        }
    }
}
