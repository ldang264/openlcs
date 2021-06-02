import tool.TreeNode;

/**
 * 给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。返回新的根。
 *
 * 例子:
 * 输入: [1,2,3,4,5]
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * 输出: 返回二叉树的根 [4,5,2,#,#,3,1]
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 * 说明:
 *
 * 对 [4,5,2,#,#,3,1] 感到困惑? 下面详细介绍请查看二叉树是如何被序列化的。
 * 二叉树的序列化遵循层次遍历规则，当没有节点存在时，'#' 表示路径终止符。
 * 这里有一个例子:
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * 上面的二叉树则被序列化为 [1,2,3,#,#,4,#,#,5].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-upside-down
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00156m {

    /**
     *
     作者：CelesteZephyr
     链接：https://leetcode-cn.com/problems/binary-tree-upside-down/solution/156-shang-xia-fan-zhuan-er-cha-shu-zi-di-4rel/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode right = null, father = null;
        while(root != null){
            //为了继续遍历，先记录下原来的左子节点防止丢失
            TreeNode left = root.left;
            //当前节点的左子节点更新为父节点的右子节点
            root.left = right;
            //记录下当前节点的右子节点
            right = root.right;
            //当前节点的右子节点更新为原父节点
            root.right = father;
            //记录下当前节点作为下一个待遍历节点的父节点（新右子节点）
            father = root;
            root = left;
        }
        //最终root=null,father指向的是最终的根节点
        return father;
    }

    /**
     * 参考了别人的题解
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode nr = upsideDownBinaryTree1(root.left); // 左子树生成新的根
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return nr;
    }
}
