import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00350s {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        return nums1.length < nums2.length ? exec(nums1, nums2) : exec(nums2, nums1);
    }

    private int[] exec(int[] shortNums, int[] longNums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : shortNums) {
            Integer c = map.get(i);
            if (c == null) {
                map.put(i, 1);
            } else {
                map.put(i, c + 1);
            }
        }
        int[] ans = new int[shortNums.length];
        int index = 0;
        for (int i : longNums) {
            Integer c = map.get(i);
            if (c != null && c > 0) {
                map.put(i, c - 1);
                ans[index++] = i;
            }
        }
        return Arrays.copyOf(ans, index);
    }
}
