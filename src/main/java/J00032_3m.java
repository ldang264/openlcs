import tool.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 提示：
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00032_3m {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean r = true; // 向右是true，向左是false
        int size = 1;
        while (size > 0) {
            LinkedList<Integer> rowList = new LinkedList<>();
            if (r) { // 向右是从头取，在尾部加；先加左子树，再加右子树
                while (size-- > 0) {
                    TreeNode node = list.removeFirst();
                    rowList.add(node.val);
                    if (node.left != null) {
                        list.addLast(node.left);
                    }
                    if (node.right != null) {
                        list.addLast(node.right);
                    }
                }
            } else { // 向右是从尾取，在头部加；先加右子树，再加左子树
                while (size-- > 0) {
                    TreeNode node = list.removeLast();
                    rowList.add(node.val);
                    if (node.right != null) {
                        list.addFirst(node.right);
                    }
                    if (node.left != null) {
                        list.addFirst(node.left);
                    }
                }
            }
            r = !r;
            ans.add(rowList);
            size = list.size();
        }
        return ans;
    }
}
