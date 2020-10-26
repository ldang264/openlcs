package q00101s_todo;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * <p>
 *
 * <p>例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * <p>1 / \ 2 2 / \ / \ 3 4 4 3
 *
 * <p>但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 * <p>1 / \ 2 2 \ \ 3 3
 *
 * <p>进阶：
 *
 * <p>你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BT_IsSymmetric {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        Random r = new Random();
        while (!list.isEmpty()) {
            int size = list.size();
            int j = 0;
            while (j < size/2) {
                TreeNode left = list.get(j);
                TreeNode right = list.get(size - 1 - j);
                if (left.val != right.val) {
                    return false;
                }
                j++;
            }
            int random = r.nextInt(1000);
            boolean allNull = true;
            while (size > 0) {
                TreeNode node = list.remove(0);
                if (node.left != null) {
                    allNull = false;
                    list.add(node.left);
                } else {
                    list.add(new TreeNode(random));
                }
                if (node.right != null) {
                    allNull = false;
                    list.add(node.right);
                } else {
                    list.add(new TreeNode(random));
                }
                size--;
            }
            if (allNull) {
                break;
            }
        }
        /*dfs(root, list);
        System.out.println(list);
        int size = list.size();
        int i = 0;
        while (i < list.size()/2) {
            if (list.get(i) != null && !list.get(i).equals(list.get(size - 1 - i))){
                return false;
            } else if (list.get(i) == null && list.get(size - 1 - i) != null) {
                return false;
            }
            i++;
        }*/
        return true;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            dfs(root.left, list);
        } else if (root.right != null){
            list.add(null);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right, list);
        } else if (root.left != null) {
            list.add(null);
        }
    }

    private static void test1() {
        BT_IsSymmetric btIS = new BT_IsSymmetric();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(btIS.isSymmetric(t1));
    }

    private static void test2() {
        BT_IsSymmetric btIS = new BT_IsSymmetric();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(2);
        t2.left = t4;
        t3.left = t5;
        System.out.println(btIS.isSymmetric(t1));
    }

    private static void test3() {
        BT_IsSymmetric btIS = new BT_IsSymmetric();
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(4);
        t2.right = t4;
        t3.right = t5;
        TreeNode t6 = new TreeNode(2);
        TreeNode t7 = new TreeNode(2);
        t4.left = t6;
        t5.left = t7;
        System.out.println(btIS.isSymmetric(t1));
    }

    private static void test4() {
        BT_IsSymmetric btIS = new BT_IsSymmetric();
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(4);
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(9);
        TreeNode t11 = new TreeNode(8);
        t5.left = t8;
        t5.right = t9;
        t7.left = t10;
        t7.right = t11;
        System.out.println(btIS.isSymmetric(t1));
    }
}
