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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00045m {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            ans++;
            int czy = nums[i] + i; //当前最远
            int start = i;
            i = czy - 1;
            int max = czy; // 记录当前可达范围内的最大值
            if (max >= nums.length - 1) return ans; // 当前已经能到最后了
            for (int j = start + 1; j <= czy; j++) {
                int fwzy = nums[j] + j; // 遍历当前范围内的最远处
                if (max < fwzy) {
                    max = fwzy;
                    i = j - 1; // 下一次用j
                }
            }
        }
        return ans;
    }
}
