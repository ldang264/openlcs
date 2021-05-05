/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 限制：
 * 1 <= 数组长度 <= 50000
 *
 * 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00039s {
    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int value = nums[0], votes = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == value) { // 加一票，
                votes++;
            } else if (votes == 0) { // 票数减到了0，重置候选项值
                value = nums[i];
            } else { // 减一票，抵消
                votes--;
            }
        }
        return value;
    }
}
