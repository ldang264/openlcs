import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1：
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 示例 2：
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *
 * 提示：
 * nums.length在1到 50,000 区间范围内。
 * nums[i]是一个在 0 到 49,999 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00697s {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] arr = numIndexMap.get(nums[i]);
            if (arr == null) {
                numIndexMap.put(nums[i], new int[]{1, i, i}); //数组下标0存储个数，1存储第一次出现的位置，2存储最后一次出现的位置
            } else {
                arr[0]++; // 更新个数
                arr[2] = i; // 更新最后一次出现的位置
            }
        }
        int maxCount = 0;
        List<Integer> list = new ArrayList<>(); // 存储出现最多次的数字
        for (Map.Entry<Integer, int[]> entry : numIndexMap.entrySet()) {
            if (maxCount < entry.getValue()[0]) {
                maxCount = entry.getValue()[0];
                list.clear();
                list.add(entry.getKey());
            } else if (maxCount == entry.getValue()[0]){
                list.add(entry.getKey());
            }

        }
        int ans = nums.length;
        for (Integer num : list) {
            int[] arr = numIndexMap.get(num);
            ans = Math.min(ans, arr[2] - arr[1] + 1);
        }
        return ans;
    }
}
