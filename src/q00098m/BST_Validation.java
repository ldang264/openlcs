package q00098m;

import tool.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *     / \
 *    3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BST_Validation {

    public static void main(String[] args) {
        BST_Validation bstV = new BST_Validation();
        TreeNode root1 = new TreeNode(2);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(3);
        root1.left = l1;
        root1.right = r1;
        System.out.println(bstV.isValidBST(root1));

        TreeNode root2 = new TreeNode(5);
        TreeNode l11 = new TreeNode(1);
        TreeNode r11 = new TreeNode(4);
        root2.left = l11;
        root2.right = r11;
        TreeNode l21 = new TreeNode(3);
        TreeNode r21 = new TreeNode(6);
        r11.left = l21;
        r11.right = r21;
        System.out.println(bstV.isValidBST(root2));

        TreeNode root3 = new TreeNode(10);
        TreeNode l31 = new TreeNode(5);
        TreeNode r31 = new TreeNode(15);
        root3.left = l31;
        root3.right = r31;
        TreeNode l32 = new TreeNode(6);
        TreeNode r32 = new TreeNode(20);
        r31.left = l32;
        r31.right = r32;
        System.out.println(bstV.isValidBST(root3));

        TreeNode root4 = new TreeNode(1);
        TreeNode l41 = new TreeNode(1);
        root4.left = l41;
        System.out.println(bstV.isValidBST(root4));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Node node = new Node(root.val);
        loop(root, node);

        Node curr1 = node, curr2 = node;
        while (curr1.next != null) {
            if (curr1.next.val <= curr1.val) {
                return false;
            }
            curr1 = curr1.next;
        }
        while (curr2.prev != null) {
            if (curr2.prev.val >= curr2.val) {
                return false;
            }
            curr2 = curr2.prev;
        }
        return true;
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

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<Integer> list = new LinkedList<>();
        if (root.left != null) {
            dfs2(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs2(root.right, list);
        }
        for (int i=0; i<list.size()-1; i++) {
            if (list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs2(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            dfs2(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            dfs2(node.right, list);
        }
    }
}
