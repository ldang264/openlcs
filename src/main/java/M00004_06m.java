import tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * 输入: root = [2,1,3], p = 1
 * 2
 * / \
 * 1   3
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: null
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/successor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00004_06m {

    /**
     * 迭代解法
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        boolean find = false;
        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (find) return root; // 是找到后的下一个
            if (root == p) find = true; // 已经找到p
            root = root.right;
        }
        return null;
    }

    /**
     * 很强的递归
     *
     * 首先说明二叉搜索树的中序是一个节点有序排列。
     * 1. 首先要确定中序遍历的后继:
     *
     * 如果该节点有右子节点, 那么后继是其右子节点的子树中最左端的节点
     * 如果该节点没有右子节点, 那么后继是离它最近的祖先, 该节点在这个祖先的左子树内.
     * 2. 使用递归实现:
     *
     * - 如果根节点小于或等于要查找的节点p, 直接进入右子树递归
     * - 如果根节点大于要查找的节点, 则暂存左子树递归查找的结果,
     *     - 如果是 null, 说明在该根节点的左子树中没找到比p大的节点，也就说明该根节点就是要找的p的后继，则直接返回当前根节点;
     *     - 如果不是 null,说明找到了答案，返回左子树递归查找的结果
     *
     * 作者：da-zui-hou
     * 链接：https://leetcode-cn.com/problems/successor-lcci/solution/java-bstzhong-xu-hou-ji-zhe-di-gui-by-da-zui-hou/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 作者：da-zui-hou
     * 链接：https://leetcode-cn.com/problems/successor-lcci/solution/java-bstzhong-xu-hou-ji-zhe-di-gui-by-da-zui-hou/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (root.val <= p.val) {
            TreeNode right = inorderSuccessor1(root.right, p);
            return right;
        } else {
            TreeNode left = inorderSuccessor1(root.left, p);
            return (left != null) ? left : root;
        }

    }

}
