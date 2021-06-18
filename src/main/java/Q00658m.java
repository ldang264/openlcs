import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * 示例 1：
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *
 * 提示：
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00658m {

    /**
     * 时间复杂度很高
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>(k);
        quickSelect(arr, k, x, 0, arr.length - 1);
        for (int i = 0; i < k; i++) {
            ans.add(arr[i]);
        }
        Collections.sort(ans);
        return ans;
    }

    private void quickSelect(int[] arr, int k, int x, int left, int right) {
        if (left >= right) return;
        int lo = left, hi = right, pivot = arr[left], sub;
        while (left < right) {
            while (left < right) {
                sub = Math.abs(arr[right] - x) - Math.abs(pivot - x);
                if (sub < 0 || (sub == 0 && arr[right] < pivot)) {
                    break;
                }
                right--;
            }
            arr[left] = arr[right];
            while (left < right) {
                sub = Math.abs(arr[left] - x) - Math.abs(pivot - x);
                if (sub > 0 || (sub == 0 && arr[left] > pivot)) {
                    break;
                }
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        sub = left - lo + 1;
        if (k < sub) {
            quickSelect(arr, k, x, lo, left - 1);
        } else if (k > sub) {
            quickSelect(arr, k - sub, x, left + 1, hi);
        }
    }
}
