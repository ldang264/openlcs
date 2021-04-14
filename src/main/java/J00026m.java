import tool.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *     3
 *    / \
 *   4   5
 *  / \
 * 1   2
 * 给定的树 B：
 *
 *   4
 *  /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00026m {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false; // 空树必不是子结构
        return match(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean match(TreeNode A, TreeNode B) {
        if (B == null) return true; // B先空了，是子结构
        if (A == null) return false; // B没空，A空了，不是子结构
        return A.val == B.val && match(A.left, B.left) && match(A.right, B.right); // 当前节点相等，且递归A和B的左右子树也满足条件
    }
}
