package q00116m;

import java.util.ArrayList;
import java.util.List;

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
public class ConnectLeftAndRightOfTree {

    public static void main(String[] args) {
        test3();
    }

    public static void test2() {
        ConnectLeftAndRightOfTree main = new ConnectLeftAndRightOfTree();
        Node n21 = new Node(2);
        Node n22 = new Node(3);
        Node n11 = new Node(1, n21, n22);
        main.connect(n11);
    }

    public static void test3() {
        ConnectLeftAndRightOfTree main = new ConnectLeftAndRightOfTree();
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
        ConnectLeftAndRightOfTree main = new ConnectLeftAndRightOfTree();
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
        if (root == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        dfs(root, list);
        int size = list.size();
        if (size == 1) {
            return root;
        } else if (size == 3) {
            list.get(0).next = list.get(2);
            return root;
        }
        int height = (int) (Math.log(size + 1) / Math.log(2));
        int i = 0;
        int j = 0;
        while(i <= (2<<height-3)/2) {
            int k = (2<<j)/2 - 1;
            while (k + (2<<j) < size) {
                list.get(k).next = list.get(k + (2<<j));
                k += (2<<j);
            }
            i = (2<<j)/2;
            j++;
        }
        return root;
    }

    private void dfs(Node root, List<Node> list) {
        if (root.left != null) {
            dfs(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            dfs(root.right, list);
        }
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
