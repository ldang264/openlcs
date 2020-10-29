package algorithm.tree;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索
 */
public class DFS {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        List<Integer> list = new ArrayList<>();
        dfs_preorder(root, list);
        //dfs_inorder(root, list);
        //dfs_postorder(root, list);
        return list;
    }

    /**
     * 递归-前序遍历
     * @param node
     * @param list
     * @return
     */
    private void dfs_preorder(TreeNode node, List<Integer> list) {
        list.add(node.val); // 根
        if (node.left != null) {
            dfs_preorder(node.left, list); // 左
        }
        if (node.right != null) {
            dfs_preorder(node.right, list); // 右
        }
    }

    /**
     * 递归-中序遍历
     * @param node
     * @param list
     * @return
     */
    private void dfs_inorder(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            dfs_preorder(node.left, list); // 左
        }
        list.add(node.val); // 根
        if (node.right != null) {
            dfs_preorder(node.right, list); // 右
        }
    }

    /**
     * 递归-后序遍历
     * @param node
     * @param list
     * @return
     */
    private void dfs_postorder(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            dfs_preorder(node.left, list); // 左
        }
        if (node.right != null) {
            dfs_preorder(node.right, list); // 右
        }
        list.add(node.val); // 根
    }
}
