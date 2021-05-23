/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 *
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 提示:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00045m {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int step = 1, idx = 0;
        while (idx < nums.length) {
            int val = nums[idx];
            if (idx + val >= nums.length - 1) break; // 直接跳到终点了
            int max = 0, next = 0;
            for (int i = idx + 1; i <= idx + val; i++) {
                if (i + nums[i] > max) { // 取跳到最远的，作为下次的起点
                    max = i + nums[i];
                    next = i;
                }
            }
            step++;
            idx = next;
        }
        return step;
    }
}
