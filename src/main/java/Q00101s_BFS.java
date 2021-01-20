import tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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

/**
 * 自己答案超时，参考官方
 * 广度优先搜索
 *
 * 注：学到了怎么判断一个数字是2的次幂  n & (n-1) = 0
 */
public class Q00101s_BFS {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null) return root.right == null;
        if (root.right == null) return false;
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        while (leftQueue.size() > 0 && rightQueue.size() > 0) {
            TreeNode left = leftQueue.poll();
            TreeNode right = rightQueue.poll();
            if (left == null && right == null) { // 都为空则继续
                continue;
            }
            if (left == null || right == null || left.val != right.val) { // 如果不同是为空或值不相等，则不对称
                return false;
            }
            // left从左向右加
            leftQueue.offer(left.left);
            leftQueue.offer(left.right);

            // right从右向左加
            rightQueue.offer(right.right);
            rightQueue.offer(right.left);
        }
        return true;
    }
}
