import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00349s {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        int maxSize, index = 0;
        Set<Integer> set;
        int[] ans;
        if (nums1.length < nums2.length) {
            maxSize = nums1.length;
            ans = new int[maxSize];
            set = new HashSet<>(maxSize);
            for (int i : nums1) {
                set.add(i);
            }
            for (int i : nums2) {
                if (set.contains(i)) {
                    ans[index++] = i;
                    set.remove(i);
                }
            }
        } else {
            maxSize = nums2.length;
            ans = new int[maxSize];
            set = new HashSet<>(maxSize);
            for (int i : nums2) {
                set.add(i);
            }
            for (int i : nums1) {
                if (set.contains(i)) {
                    ans[index++] = i;
                    set.remove(i);
                }
            }
        }
        if (index == 0) return new int[0];
        int [] realAns = new int[index];
        System.arraycopy(ans, 0, realAns, 0, index);
        return realAns;
    }
}
