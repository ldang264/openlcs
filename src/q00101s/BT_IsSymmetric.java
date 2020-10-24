package q00101s;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    public boolean isSymmetric(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int size = list.size();
        int i = 0;
        while (i < list.size()/2) {
            if (list.get(i) != list.get(size - 1 - i)){
                return false;
            }
            i++;
        }
        return true;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            dfs(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right, list);
        }
    }
}
