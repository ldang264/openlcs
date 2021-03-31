package ans;

import tool.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 作者：sdwwld
 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst/solution/di-gui-he-fei-di-gui-liang-chong-fang-shi-du-ji--3/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q00450m_Ans {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        //通过递归的方式要先找到要删除的结点
        if (key < root.val) {
            //要删除的节点在左子树上
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            //要删除的节点在右子树上
            root.right = deleteNode(root.right, key);
        } else {
            //找到了要删除的节点。
            //如果左子树为空，我们只需要返回右子树即可
            if (root.left == null)
                return root.right;
            //如果右子树为空，我们只需要返回左子树即可
            if (root.right == null)
                return root.left;
            //说明两个子节点都不为空，我们可以找左子树的最大值，
            //也可以找右子树的最小值替换

            //这里是用右子树的最小值替换
            //TreeNode minNode = findMin(root.right);
            //root.val = minNode.val;
            //root.right = deleteNode(root.right, root.val);

            //这里是用左子树的最大值替换
            TreeNode maxNode = findMax(root.left);
            root.val = maxNode.val;
            root.left = deleteNode(root.left, root.val);
        }
        return root;
    }

    //    找右子树的最小值
    //    private TreeNode findMin(TreeNode node) {
    //        while (node.left != null)
    //            node = node.left;
    //        return node;
    //    }

    //找左子树的最大值
    private TreeNode findMax(TreeNode node) {
        while (node.right != null)
            node = node.right;
        return node;
    }

}
