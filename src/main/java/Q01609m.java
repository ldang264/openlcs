import tool.TreeNode;

import java.util.LinkedList;

/**
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 *
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * 输出：true
 * 解释：每一层的节点值分别是：
 * 0 层：[1]
 * 1 层：[10,4]
 * 2 层：[3,7,9]
 * 3 层：[12,8,6,2]
 * 由于 0 层和 2 层上的节点值都是奇数且严格递增，而 1 层和 3 层上的节点值都是偶数且严格递减，因此这是一棵奇偶树。
 * 示例 2：
 *
 *
 *
 * 输入：root = [5,4,2,3,3,7]
 * 输出：false
 * 解释：每一层的节点值分别是：
 * 0 层：[5]
 * 1 层：[4,2]
 * 2 层：[3,3,7]
 * 2 层上的节点值不满足严格递增的条件，所以这不是一棵奇偶树。
 * 示例 3：
 *
 *
 *
 * 输入：root = [5,9,1,3,5,7]
 * 输出：false
 * 解释：1 层上的节点值应为偶数。
 * 示例 4：
 *
 * 输入：root = [1]
 * 输出：true
 * 示例 5：
 *
 * 输入：root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
 * 输出：true
 *  
 *
 * 提示：
 *
 * 树中节点数在范围 [1, 105] 内
 * 1 <= Node.val <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/even-odd-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01609m {
    public static void main(String[] args) {
        Q01609m ieot = new Q01609m();
        //1,10,4,3,null,7,9,12,8,6,null,null,2
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(10);
        TreeNode t3 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(3);
        t2.left = t4;
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        t3.left = t5;
        t3.right = t6;
        TreeNode t7 = new TreeNode(12);
        TreeNode t8 = new TreeNode(8);
        t4.left = t7;
        t4.right = t8;
        TreeNode t9 = new TreeNode(6);
        t5.left = t9;
        TreeNode t10 = new TreeNode(2);
        t6.right = t10;
        System.out.println(ieot.isEvenOddTree(t1));
    }

    public boolean isEvenOddTree(TreeNode root) {
        boolean even = true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (list.size() > 0) {
            int size = list.size();
            int last = even ? -1 : 1000002;
            while (size-- > 0) {
                TreeNode node = list.pop();
                if (even) {
                    if (node.val <= last || node.val % 2 == 0) {
                        return false;
                    }
                    last = node.val;
                } else {
                    if (node.val >= last || node.val % 2 == 1) {
                        return false;
                    }
                    last = node.val;
                }
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            even = !even;
        }
        return true;
    }
}
