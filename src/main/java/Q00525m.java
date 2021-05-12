import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 *
 * 示例 1:
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 *
 * 示例 2:
 * 输入: [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 * 注意: 给定的二进制数组的长度不会超过50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00525m {

    /**
     * 前缀和：自己没做出来，看了答案后有了思路
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int ans = 0, preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // 初始值
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i] == 0 ? -1 : 1; // 0就减1, 1就加1
            Integer idx = map.get(preSum); // 拿到前缀和的最小下标
            if (idx == null) {
                map.put(preSum, i);
            } else { // 已存在则说明在这段区间内，01相抵
                ans = Math.max(ans, i - idx);
            }
        }
        return ans;
    }
}
