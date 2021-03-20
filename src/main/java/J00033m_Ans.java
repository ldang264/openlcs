/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 提示：
 *
 * 数组长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00033m_Ans {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    boolean helper(int[] postorder, int left, int right) {
        //如果left==right，就一个节点不需要判断了，如果left>right说明没有节点，
        //也不用再看了,否则就要继续往下判断
        if (left >= right)
            return true;
        /**
         * 因为数组中最后一个值postorder[right]是根节点，这里从左往右找出第一个比
         * 根节点大的值，他后面的都是根节点的右子节点（包含当前值，不包含最后一个值，
         * 因为最后一个是根节点），他前面的都是根节点的左子节点
         */
        int mid = left;
        int root = postorder[right];
        while (postorder[mid] < root)
            mid++;
        int temp = mid;
        /**
         * 因为postorder[mid]前面的值都是比根节点root小的，
         * 我们还需要确定postorder[mid]后面的值都要比根节点root大，
         * 如果后面有比根节点小的直接返回false
         */
        while (temp < right) {
            if (postorder[temp++] < root)
                return false;
        }
        //然后对左右子节点进行递归调用
        return helper(postorder, left, mid - 1) && helper(postorder, mid, right - 1);
    }

}
