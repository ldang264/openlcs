package q00106;

import tool.TreeNode;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
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
public class BuildTree {

    public static void main(String[] args) {
        BuildTree bt = new BuildTree();
        TreeNode treeNode= bt.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) { //无数据，返回空
            return null;
        }
        // 取后序的最后一个元素作为根
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if (postorder.length > 1) {
            root.right = new TreeNode(postorder[postorder.length - 2]);
            int[] post = new int[postorder.length - 2];
            System.arraycopy(postorder, 0, post, 0, post.length);
        } else {
            return root;
        }
        for (int i=0; i<inorder.length; i++) {
            if (inorder[i] == root.val) {
                // 在中序遍历中找到了根
                if (i < inorder.length - 1) {
                    // 如果右边有值，则一定是它的右节点
                    root.right = new TreeNode(inorder[i + 1]);
                } else if (i > 0){
                    // 否则左边一定是它的左节点
                    root.left = new TreeNode(inorder[i-1]);
                }
                /*if (i == 0) {
                    int[] in = new int[inorder.length - 1];
                    System.arraycopy(postorder, 0, post, 0, post.length);
                } else if (i == 1) {
                    int[] in = new int[inorder.length - 2];
                    root.left = new TreeNode(inorder[i-1]);
                    System.arraycopy(inorder, 0, post, 0, post.length);
                } else {

                }*/
                break;
            }
        }
        return root;
    }

    public void build(TreeNode currentNode, int[] in, int[] post) {
        if (in.length == 1) {
            currentNode.right = new TreeNode(in[0]);
            return;
        } else {

        }
    }
}
