package q00107s;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>(); // 队列，节点先进先出
        queue.offer(root);
        return bfs(queue, lists);
    }

    /**
     * 广度优先遍历
     * @param queue
     * @param lists
     * @return
     */
    private List<List<Integer>> bfs(Queue<TreeNode> queue, LinkedList<List<Integer>> lists) {
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            while (size-- > 0) { // 一次性把一层全部弹出
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            lists.addFirst(list); // 因为是逆序，所以加载链表头
        }
        return lists;
    }
}
