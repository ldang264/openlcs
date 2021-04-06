package algorithm.tree;

import tool.TreeNode;

import java.util.*;

/**
 * 深度优先搜索
 */
public class DFS {

    /**
     * 迭代-前序遍历
     * @param root
     */
    public void dfs_iteration_preorder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.val + " ");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    /**
     * 迭代-中序遍历
     * @param root
     */
    public void dfs_iteration_inorder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    /**
     * 迭代-后序遍历
     * @param root
     */
    public void dfs_iteration_postorder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode last = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if (curr.right == null || curr.right == last) {
                System.out.print(curr.val + " ");
                stack.pop();
                last = curr;
                curr = null;
            } else {
                curr = curr.right;
            }
        }
    }

    /**
     * 递归-前序遍历
     * @param root
     * @return
     */
    public void dfs_recursion_preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " "); // 根
            dfs_recursion_preorder(root.left); // 左
            dfs_recursion_preorder(root.right); // 右
        }
    }

    /**
     * 递归-中序遍历
     * @param root
     * @return
     */
    public void dfs_recursion_inorder(TreeNode root) {
        if (root != null) {
            dfs_recursion_inorder(root.left); // 左
            System.out.print(root.val + " "); // 根
            dfs_recursion_inorder(root.right); // 右
        }
    }

    /**
     * 递归-后序遍历
     * @param root
     * @return
     */
    public void dfs_recursion_postorder(TreeNode root) {
        if (root != null) {
            dfs_recursion_postorder(root.left); // 左
            dfs_recursion_postorder(root.right); // 右
            System.out.print(root.val + " "); // 根
        }
    }
}
