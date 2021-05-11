import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 提示：
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00128h {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0, count;
        for (Integer num : set) {
            if (!set.contains(num - 1)) { // 找到起点位置
                count = 1;
                while (set.contains(++num)) {
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    /*
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int ans = 1, count, temp;
        Set<Integer> checked = new HashSet<>();
        for (Integer num : set) {
            if (checked.add(num)) {
                temp = num;
                count = 1;
                while (set.contains(++temp)) {
                    checked.add(temp);
                    count++;
                }
                while (set.contains(--num)) {
                    checked.add(num);
                    count++;
                }
                if (count > ans) {
                    ans = count;
                }
            }
        }
        return ans;
    }*/
}
