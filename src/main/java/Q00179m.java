import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 示例2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 *
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00179m {
    public String largestNumber(int[] nums) {
        int[] array = sort(nums);
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    private int[] sort(int[] nums) {
        if (nums.length == 1) return nums;
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] array = new int[left.length + right.length];
        for (int i = 0, j = 0, k = 0; i < array.length; i++) {
            if (j == left.length) {
                array[i] = right[k++];
            } else if (k == right.length) {
                array[i] = left[j++];
            } else {
                // 两两正反拼接比较，大的在前
                String l = String.valueOf(left[j]);
                String r = String.valueOf(right[k]);
                array[i] = (l + r).compareTo(r + l) > 0 ? left[j++] : right[k++];
            }
        }
        return array;
    }
}
