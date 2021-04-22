import tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00105m {

    private Map<Integer, Integer> inMap; // 中序放到map中缓存

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, 0, preorder.length - 1);
    }

    /**
     *
     * @param preorder 前序数组
     * @param preIndex 前序根的下标
     * @param start 前序数组中最左子节点的下标
     * @param end 前序数组中最右子节点的下标
     * @return
     */
    private TreeNode build(int[] preorder, int preIndex, int start, int end) {
        int inIndex = inMap.get(preorder[preIndex]); // 中序里面根的下标
        TreeNode root = new TreeNode(preorder[preIndex]);
        if (inIndex > start) { // 有左节点
            root.left = build(preorder, preIndex + 1, start, inIndex - 1);
        }
        if (inIndex < end) { // 有右节点
            for (int i = Math.max(preIndex, inIndex) + 1; i < preorder.length; i++) {
                if (inMap.get(preorder[i]) > inIndex) { // 找到第一个下标比中序下标大的，是右子节点
                    root.right = build(preorder, i, inIndex + 1, end);
                    break;
                }
            }
        }
        return root;
    }
}
