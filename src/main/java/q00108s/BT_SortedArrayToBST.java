package q00108s;

import tool.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BT_SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return loop(nums, 0, nums.length - 1);
    }

    private TreeNode loop(int[] nums, int start, int end) {
        if (end < start) return null;
        if (end == start) return new TreeNode(nums[start]);
        if (end - start == 1) {
            TreeNode root = new TreeNode(nums[end]);
            root.left = new TreeNode(nums[start]);
            return root;
        } else if (end - start == 2) {
            TreeNode root = new TreeNode(nums[end - 1]);
            root.left = new TreeNode(nums[start]);
            root.right = new TreeNode(nums[end]);
            return root;
        } else {
            int midIndex = (end + start) / 2;
            TreeNode left = loop(nums, start, midIndex - 1);
            TreeNode right = loop(nums, midIndex + 1, end);
            TreeNode root = new TreeNode(nums[midIndex]);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
