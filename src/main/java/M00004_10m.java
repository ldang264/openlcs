import tool.TreeNode;

/**
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * 注意：此题相对书上原题略有改动。
 *
 * 示例1:
 *  输入：t1 = [1, 2, 3], t2 = [2]
 *  输出：true
 *
 * 示例2:
 *  输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 *  输出：false
 *
 * 提示：
 * 树的节点数目范围为[0, 20000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-subtree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00004_10m {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        return valid(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    /**
     * 检查当前节点是否相等，并且左右子树是否相等
     * @param t1
     * @param t2
     * @return
     */
    private boolean valid(TreeNode t1, TreeNode t2) {
        if (t2 == null) return t1 == null;
        if (t1 == null) return false;
        return t1.val == t2.val && valid(t1.left, t2.left) && valid(t1.right, t2.right);
    }
}
