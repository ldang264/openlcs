import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数k，你需要找到该数组中和为k的连续的子数组的个数。
 *
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数k的范围是[-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00560m {

    /**
     * 前缀和，参考了答案
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // 键是和，值是和的个数
        map.put(0, 1); // 等于k的也会有
        int ans = 0, sum = 0;
        for (int num : nums) {
            sum += num; // 当前和
            Integer count = map.get(sum - k); // 如果差已经在map中，说明两者和等于k
            if (count != null) {
                ans += count; // 加上它累计的数量
            }
            map.merge(sum, 1, Integer::sum); // 对当前和进行计数更新
        }
        return ans;
    }

    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
