import java.util.Arrays;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 * 通过次数23,136提交次数42,499
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_14m {
    public int[] smallestK(int[] arr, int k) {
        sort(arr, k, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void sort(int[] arr, int k, int left, int right) {
        if (left >= right) return;
        int l = left;
        int r = right;
        int pivot = arr[left]; // 基准值
        while (left < right) {
            while (left < right && arr[right] >= pivot) { // 找到第一个小的
                right--;
            }
            arr[left] = arr[right]; // 小的往前
            while (left < right && arr[left] <= pivot) { // 找到第一个大的
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot; // 将基准值放在正确的位置，左边比它小，右边比它大
        int range = left - l + 1;
        if (k < range) { // 在左边找k个数
            sort(arr, k, l, left - 1);
        } else if (k > range) { // 左边排好了，但右边还有k-range个数没排好
            sort(arr, k - range, left + 1, r);
        }
    }
}
