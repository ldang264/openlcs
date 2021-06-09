import java.util.LinkedList;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00503m {

    /**
     * 单调栈
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        LinkedList<Integer> list = new LinkedList<>(); // 存放下标
        for (int i = 0; i < nums.length; i++) {
            Integer head;
            while ((head = list.peekLast()) != null && nums[i] > nums[head]) {
                list.removeLast();
                ans[head] = nums[i];
            }
            list.addLast(i);
        }
        int i;
        int end = list.peekFirst(); // 一定不会超过峰值
        while (list.size() > 0) {
            i = 0;
            int index = list.removeLast(); // 依次从小到大取出
            ans[index] = -1;
            while (i <= end) { // 从0遍历到最大值
                if (nums[i] > nums[index]) {
                    ans[index] = nums[i];
                    break;
                }
                i++;
            }
        }
        return ans;
    }
}
