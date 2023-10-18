package algorithm.tree;

import tool.TreeNode;

import java.util.*;

/**
 * 深度优先搜索
 * 三种遍历算法
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
            root = stack.pop(); // 直接先弹出根
            System.out.print(root.val + " ");
            if (root.right != null) {
                stack.push(root.right); // 右节点后被弹出
            }
            if (root.left != null) {
                stack.push(root.left); // 左节点先被弹出
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
                stack.push(root); // 一直会将左节点入栈
                root = root.left;
            }
            root = stack.pop(); // 依次弹出左节点、根、右节点
            System.out.print(root.val + " ");
            root = root.right; // 处理右子树
        }
    }

    /**
     * 迭代-后序遍历
     * @param root
     */
    public void dfs_iteration_postorder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode last = null; // 需要增加前一个节点的引用
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek(); // 取栈顶元素
            if (curr.right == null || curr.right == last) { // 如果没有右节点或者右节点刚被处理过
                System.out.print(curr.val + " "); // 处理根
                stack.pop(); // 弹出根
                last = curr; // 比较根已被处理过
                curr = null; // 当前对象清空
            } else {
                curr = curr.right; //
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
