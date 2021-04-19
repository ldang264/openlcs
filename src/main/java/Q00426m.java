/**
 * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 *
 * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,5,1,3]
 *
 *
 * 输出：[1,2,3,4,5]
 *
 * 解释：下图显示了转化后的二叉搜索树，实线表示后继关系，虚线表示前驱关系。
 *
 * 示例 2：
 *
 * 输入：root = [2,1,3]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 * 解释：输入是空树，所以输出也是空链表。
 * 示例 4：
 *
 * 输入：root = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * -1000 <= Node.val <= 1000
 * Node.left.val < Node.val < Node.right.val
 * Node.val 的所有值都是独一无二的
 * 0 <= Number of Nodes <= 2000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00426m {

    private Node head;

    private Node prev;

    public Node treeToDoublyList(Node root) {
        dfs(root);
        if (head != null) { // 关联首尾节点
            head.left = prev;
            prev.right = head;
        }
        return head;
    }

    private void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        if (head == null) head = root; // 最小值的节点
        if (prev != null) { // 前后两个节点关联
            prev.right = root;
            root.left = prev;
        }
        prev = root; // 更新前一个节点
        dfs(root.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
