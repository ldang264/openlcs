package q00530;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BST_MinimumDifference {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        BST_MinimumDifference md = new BST_MinimumDifference();
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(7);
        root.right = t2;
        root.left = t1;
        System.out.println(md.getMinimumDifference(root));
    }

    public static void test1() {
        BST_MinimumDifference md = new BST_MinimumDifference();
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(6);
        root.right = t1;
        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t4.left = t5;
        System.out.println(md.getMinimumDifference(root));
    }

    public int getMinimumDifference(TreeNode root) {
        Node node = new Node(root.val);
        loop(root, node);
        int sub = Integer.MAX_VALUE;
        Node curr1 = node, curr2 = node;
        while (curr1.next != null) {
            int s = curr1.next.val - curr1.val;
            if (s < sub) {
                sub = s;
            }
            curr1 = curr1.next;
        }
        while (curr2.prev != null) {
            int s = curr2.val - curr2.prev.val;
            if (s < sub) {
                sub = s;
            }
            curr2 = curr2.prev;
        }
        return sub;
    }

    private void loop(TreeNode t, Node n) {
        if (t.left != null) {
            Node curr = new Node(t.left.val);
            Node prev = n.prev;
            if (prev != null) {
                prev.next = curr;
                curr.prev = prev;
            }
            n.prev = curr;
            curr.next = n;
            loop(t.left, n.prev);
        }
        if (t.right != null) {
            Node curr = new Node(t.right.val);
            Node next = n.next;
            if (next != null) {
                next.prev = curr;
                curr.next = next;
            }
            n.next = curr;
            curr.prev = n;
            loop(t.right, n.next);
        }
    }

    static class Node {
        int val;

        Node prev;

        Node next;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            if (next == null) {
                return val + "";
            }
            return val + " " + next.toString();
        }
    }

    public int getMinimumDifference1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        loop(root, list);
        Collections.sort(list);
        int min = list.get(1) - list.get(0);
        for (int i=1; i<list.size()-1; i++) {
            int sub = list.get(i+1) - list.get(i);
            if (sub < min) {
                min = sub;
            }
        }
        return min;
    }

    public void loop(TreeNode t, List<Integer> list) {
        if (t.left != null) {
            list.add(t.left.val);
            loop(t.left, list);
        }
        if (t.right != null) {
            list.add(t.right.val);
            loop(t.right, list);
        }
    }
}
