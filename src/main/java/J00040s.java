import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]<= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00040s {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        sort(arr, k, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void sort(int[] arr, int k, int left, int right) {
        if (left >= right) return;
        int l = left, r = right, pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) { // 向左找小
                right--;
            }
            arr[left] = arr[right]; // 小的换到前面去
            while (left < right && arr[left] <= pivot) { // 向右找大
                left++;
            }
            arr[right] = arr[left]; // 大的换到后面去
        }
        arr[left] = pivot; // 基准值放到正确的位置
        int range = left - l + 1; // 左边排好序的数据个数
        if (k < range) {
            sort(arr, k, l, left - 1);
        } else if (k > range) {
            sort(arr, k - range, left + 1, r);
        }
    }
}
