import tool.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为O(h)，h 为树的高度。
 *
 * 示例:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
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
public class Q00450m {

    private TreeNode prev;

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode dummyNode = new TreeNode(0);
        dummyNode.left = root;
        prev = dummyNode;
        handle(root, key);
        return dummyNode.left;
    }

    private void handle(TreeNode root, int key) {
        if (root != null) {
            if (root.val == key) { // 找到了目标key
                if (root.left == null) {
                    if (root.right == null) { // 删除当前节点即可
                        if (prev.left == root) {
                            prev.left = null;
                        } else {
                            prev.right = null;
                        }
                    } else { // 找到右子树上最小的
                        // 左中右的顺序找第一个，也就是正常的中序遍历
                        TreeNode target = findMinOfRightSubTree(root.right);
                        root.val = target.val;
                        // 嫁接
                        if (target == root.right) { // 右子节点没有左子树
                            root.right = target.right;
                        } else {
                            prev.left = target.right;
                        }
                    }
                } else { // 找左子树上最大的
                    // 右中左的顺序找第一个，也就是反过来的中序遍历
                    TreeNode target = findMaxOfLeftSubTree(root.left);
                    root.val = target.val;
                    // 嫁接
                    if (target == root.left) { // 左子节点没有右子树
                        root.left = target.left;
                    } else {
                        prev.right = target.left;
                    }
                }
                return;
            } else {
                prev = root;
                handle(root.val > key ? root.left : root.right, key);
            }
        }
    }

    /**
     * 找右子树的最小值
     * @param root
     * @return
     */
    private TreeNode findMinOfRightSubTree(TreeNode root) {
        if (root.left == null) return root;
        prev = root;
        return findMinOfRightSubTree(root.left);
    }

    /**
     * 找左子树最大值
     * @param root
     * @return
     */
    private TreeNode findMaxOfLeftSubTree(TreeNode root) {
        if (root.right == null) return root;
        prev = root;
        return findMaxOfLeftSubTree(root.right);
    }

}
