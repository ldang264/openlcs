package algorithm.tree;

import tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历
 */
public class BFS {

    public void levelOrder(TreeNode tree) {
        if (tree == null)
            return;
        bfs(tree);
    }

    private void bfs(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);//相当于把数据加入到队列尾部
        while (!queue.isEmpty()) {
            //poll方法相当于移除队列头部的元素
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
