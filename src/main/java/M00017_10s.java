import java.util.HashMap;
import java.util.Map;

/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 *
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 说明：
 * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00017_10s {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = nums[0], mc = 1;
        for (int num : nums) {
            int count = map.merge(num, 1, Integer::sum);
            if (count > mc) {
                mc = count;
                max = num;
            }
        }
        if (mc <= nums.length / 2) return -1;
        return max;
    }

    /**
     * 答案：福尔摩斯投票法
     作者：hxz1998
     链接：https://leetcode-cn.com/problems/find-majority-element-lcci/solution/java-fu-er-mo-si-tou-piao-fa-zhu-xing-zh-0y6d/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int majorityElementAns(int[] nums) {
        // prev 用来记录上一个有效的投票人，count用来记录他的有效投票数
        int prev = -1, count = 0;
        for (int i : nums) {
            // 如果 count == 0，说明之前的都抵消掉了，从新开始
            if (count == 0) {
                count++;
                prev = i;
            } else if (prev == i) {
                // 说明遇到了相同的投票，直接相加就好了
                count++;
            } else {
                // 说明遇到了不同的，那么就抵消掉一票
                --count;
            }
        }
        // 检查个数是不是真的超过了 1/2
        if (count > 0) {
            int n = 0;
            for (int i : nums) if (i == prev) n++;
            if (n > nums.length / 2) return prev;
        }
        return -1;
    }

}
