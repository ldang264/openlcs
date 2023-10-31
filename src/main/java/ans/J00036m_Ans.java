package ans;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * 注意：此题对比原题有改动。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00036m_Ans {

    private Node head;
    private Node preNode;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        dfs(root);
        /*
        后续处理：
            让 head的左子指针 指向 最后一个节点
            让 最后一个节点的右子指针 指向 head
        形成闭环
        */
        head.left = preNode;
        preNode.right = head;
        return head;
    }

    private void dfs(Node curRoot) {
        if (curRoot == null) {
            return;
        }

        dfs(curRoot.left);
    /*
        判断当前是否是第一个节点(最小节点)：
            若是，则让 head 指向 当前节点
            若不是，则让 前驱节点的右子指针 指向 当前节点
    */
        if (preNode == null) {
            head = curRoot;
        } else {
            preNode.right = curRoot;
        }
        curRoot.left = preNode; // 让 当前节点的左子指针 指向 前驱节点
        preNode = curRoot;  // 让 前驱节点 指向 当前节点
        dfs(curRoot.right);
    }

    /**
    * 内部类
    */
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
