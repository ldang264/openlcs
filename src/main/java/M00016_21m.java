import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 *
 * 示例:
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 *
 * 示例:
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 *
 * 提示：
 * 1 <= array1.length, array2.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-swap-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M00016_21m {
    public int[] findSwapValues(int[] array1, int[] array2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        int temp = 0;
        for (int num1 : array1) {
            temp += num1; // 用作array1的元素和
            set1.add(num1);
        }
        for (int num2 : array2) {
            temp -= num2; // 用作array1与array2的和差
            set2.add(num2);
        }
        if ((temp & 1) == 1) return new int[0]; // 奇数，肯定无法协调
        temp >>= 1;
        for (Integer num2 : set2) {
            if (set1.contains(num2 + temp)) {
                return new int[]{num2 + temp, num2};
            }
        }
        return new int[0];
    }
}
