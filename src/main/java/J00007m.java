import tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00007m {

    private Map<Integer, Integer> inMap; // 用于存放中序的值和下标的映射

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) return null;
        inMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return treeify(preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode treeify(int[] preorder, int preIndex, int start, int end) {
        TreeNode root = new TreeNode(preorder[preIndex]); // 构造根
        int inIndex = inMap.get(preorder[preIndex]); // 根节点在中序的下标
        if (inIndex > start) { // 一定有左子节点
            root.left = treeify(preorder, preIndex + 1, start, inIndex - 1);
        }
        if (inIndex < end) { // 右子节点因为会被左子节点隔开，所以需要去找
            for (int i = preIndex + 1; i < preorder.length; i++) {
                if (inMap.get(preorder[i]) > inIndex) { // 第一个下标大于根的，一定是右子节点
                    root.right = treeify(preorder, i, inIndex + 1, end);
                    break;
                }
            }
        }
        return root;
    }
}
