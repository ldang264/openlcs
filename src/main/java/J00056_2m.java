import java.util.HashMap;
import java.util.Map;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 * 限制：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00056_2m {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 3 + 1);
        for (int num : nums) {
            Integer count = map.remove(num); // 2个的时候就会丢弃，其他可以拿到旧值
            if (count == null) {
                map.put(num, 1); // 一个都没有，就加入
            } else if (count == 1){
                map.put(num, 2); // 已经有一个，就加进去
            }
        }
        return map.keySet().iterator().next(); // map中只会有一个元素
    }
}
