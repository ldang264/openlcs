import tool.ListNode;
import tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 * 示例：
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \ 
 *       2    3
 *      / \    \ 
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00004_03m {

    /**
     * 广度优先遍历
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[0];
        List<ListNode> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        int size;
        while ((size = queue.size()) > 0) {
            ListNode hair = new ListNode(0), curr = hair;
            while (size-- > 0) {
                tree = queue.poll();
                curr.next = new ListNode(tree.val); // 构造链表链
                curr = curr.next;
                if (tree.left != null) queue.offer(tree.left);
                if (tree.right != null) queue.offer(tree.right);
            }
            nodes.add(hair.next);
        }
        return nodes.toArray(new ListNode[0]);
    }
}
