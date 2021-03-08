import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前k高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 提示：
 *
 * 你可以假设给定的k总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) ,n是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00347m {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int[] ans = new int[map.size()];
        int index = 0;
        for (Integer num : map.keySet()) {
            ans[index++] = num;
        }
        // 比较的是从map的取出的value
        sort(ans, k, 0, ans.length - 1, map);
        return Arrays.copyOf(ans, k);
    }

    private void sort(int[] nums, int k, int left, int right, Map<Integer, Integer> map) {
        if (left >= right) return;
        int l = left, r = right, pivot = nums[left];
        while (left < right) {
            while (left < right && map.get(nums[right]) <= map.get(pivot)) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && map.get(nums[left]) >= map.get(pivot)) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        int range = left - l + 1;
        if (k < range) {
            sort(nums, k, l, left - 1, map);
        } else if (k > range) {
            sort(nums, k - range, left + 1, r, map);
        }
    }
}
