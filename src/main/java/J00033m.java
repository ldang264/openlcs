
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
public class J00033m {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length <= 1) return true;
        return validate(postorder, 0, postorder.length - 1);
    }

    /**
     *
     * @param postorder
     * @param start 开始遍历的位置
     * @param index 根节点位置
     * @return
     */
    private boolean validate(int[] postorder, int start, int index) {
        if (start >= index) return true;
        int left = start;
        while (left < index) {
            if (postorder[left] > postorder[index]) break; // 找到右子树的起点
            left++;
        }
        int right = index - 1;
        while (right >= 0) {
            if (postorder[right] < postorder[index]) break; // 找到左子树的起点
            right--;
        }
        if (left - right != 1) return false; // 如果左右子树不相差1，则验证通过
        return validate(postorder, start, right) && validate(postorder, left, index - 1); // 递归验证左右子树
    }
}
