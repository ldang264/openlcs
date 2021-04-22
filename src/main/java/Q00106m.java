import tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00106m {

    private Map<Integer, Integer> inMap; // 中序放到map中缓存

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(postorder, postorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postIndex, int start, int end) {
        TreeNode root = new TreeNode(postorder[postIndex]);
        int inIndex = inMap.get(postorder[postIndex]);
        if (inIndex < end) { // 有右子节点
            root.right = build(postorder, postIndex - 1, inIndex + 1, end);
        }
        if (inIndex > start) {
            for (int i = Math.min(postIndex, inIndex) - 1; i >= 0; i--) {
                if (inMap.get(postorder[i]) < inIndex) { // 找到第一个下标比中序小的，就是左子节点
                    root.left = build(postorder, i, start, inIndex - 1);
                    break;
                }
            }
        }
        return root;
    }
}
