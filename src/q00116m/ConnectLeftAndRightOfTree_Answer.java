package q00116m;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 *
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 *
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *  
 *
 * 提示：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *
 作者：sdwwld
 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/bfshe-di-gui-zui-hou-liang-chong-ji-bai-liao-100-2/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ConnectLeftAndRightOfTree_Answer {

    public static void main(String[] args) {
        test3();
    }

    public static void test2() {
        ConnectLeftAndRightOfTree_Answer main = new ConnectLeftAndRightOfTree_Answer();
        Node n21 = new Node(2);
        Node n22 = new Node(3);
        Node n11 = new Node(1, n21, n22);
        main.connect(n11);
    }

    public static void test3() {
        ConnectLeftAndRightOfTree_Answer main = new ConnectLeftAndRightOfTree_Answer();
        Node n31 = new Node(4);
        Node n32 = new Node(5);
        Node n33 = new Node(6);
        Node n34 = new Node(7);
        Node n21 = new Node(2, n31, n32);
        Node n22 = new Node(3, n33, n34);
        Node n11 = new Node(1, n21, n22);
        main.connect(n11);
    }

    public static void test4() {
        ConnectLeftAndRightOfTree_Answer main = new ConnectLeftAndRightOfTree_Answer();
        Node n41 = new Node(8);
        Node n42 = new Node(9);
        Node n43 = new Node(10);
        Node n44 = new Node(11);
        Node n45 = new Node(12);
        Node n46 = new Node(13);
        Node n47 = new Node(14);
        Node n48 = new Node(15);
        Node n31 = new Node(4, n41, n42);
        Node n32 = new Node(5, n43, n44);
        Node n33 = new Node(6, n45, n46);
        Node n34 = new Node(7, n47, n48);
        Node n21 = new Node(2, n31, n32);
        Node n22 = new Node(3, n33, n34);
        Node n11 = new Node(1, n21, n22);
        main.connect(n11);
    }

    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null)
            return;
        curr.next = next;
        dfs(curr.left, curr.right);
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }

    public Node connect1(Node root) {
        if (root == null)
            return root;
        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示下一层节点的前一个节点
            Node pre = dummy;

            //然后开始遍历当前层的链表
            //因为是完美二叉树，如果有左子节点就一定有右子节点
            while (cur != null && cur.left != null) {
                //让pre节点的next指向当前节点的左子节点，也就是把它串起来
                pre.next = cur.left;
                //然后再更新pre
                pre = pre.next;

                //pre节点的next指向当前节点的右子节点，
                pre.next = cur.right;
                pre = pre.next;
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null)
            return null;
        Node pre = root;
        Node cur = null;
        while (pre.left != null) {
            //遍历当前这一层的结点，然后把他们的下一层连接起来
            cur = pre;
            //cur不为空，就表示这一层还没遍历完，就继续循环
            while (cur != null) {
                //让下一层的左子节点指向右子节点
                cur.left.next = cur.right;
                //如果cur.next不为空，就表示还没遍历到这一层
                //最后的那个节点的右子节点，就让前一个结点的右
                //子节点指向下一个节点的左子节点
                if (cur.next != null)
                    cur.right.next = cur.next.left;
                //然后继续连接下一个节点的 子节点
                cur = cur.next;
            }
            //继续下一层
            pre = pre.left;
        }
        return root;
    }

    public Node connect_45(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //每一层的数量
            int levelCount = queue.size();
            //前一个节点
            Node pre = null;
            for (int i = 0; i < levelCount; i++) {
                //出队
                Node node = queue.poll();
                //如果pre为空就表示node节点是这一行的第一个，
                //没有前一个节点指向他，否则就让前一个节点指向他
                if (pre != null) {
                    pre.next = node;
                }
                //然后再让当前节点成为前一个节点
                pre = node;
                //左右子节点如果不为空就入队
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
