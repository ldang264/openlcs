import tool.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树: root =[3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00068_2s {

    private List<TreeNode> list;

    private Set<TreeNode> set;

    private boolean pe, qe;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        list = new ArrayList<>();
        set = new HashSet<>();
        dfs(root, p, q);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (set.contains(list.get(i))) {
                return list.get(i);
            }
        }
        return null;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (pe && qe)) return;
        if (!pe) set.add(root);
        if (!qe) list.add(root);
        dfs(root.left, p, q);
        if (!pe) {
            if (root == p) {
                pe = true;
            }
        }
        if (!qe) {
            if (root == q) {
                qe = true;
            }
        }
        dfs(root.right, p, q);
        if (!pe) set.remove(root);
        if (!qe) list.remove(list.size() - 1);
    }
}
