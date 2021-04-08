package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 *
 * 算法描述
 *
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 *
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * 平均时间复杂度：O(nlogn) 最好：O(nlogn) 最坏：O(n^2)
 * 空间复杂度：O(logn)
 * 是否占用额外内存：否
 * 是否稳定：否
 */

/**
 *
 作者：LeetCode-Solution
 链接：https://leetcode-cn.com/problems/sort-an-array/solution/pai-xu-shu-zu-by-leetcode-solution/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class QuickSort_Random {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 4, 3, 2, 2, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pos = partition(nums, left, right);
        quickSort(nums, left, pos - 1);
        quickSort(nums, pos + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int i = new Random().nextInt(right - left + 1) + left; // 随机选一个作为我们的主元
        swap(nums, right, i);
        int pivot = nums[right];
        int k = left - 1;
        for (int j = left; j <= right - 1; ++j) {
            if (nums[j] <= pivot) {
                k = k + 1;
                swap(nums, k, j);
            }
        }
        swap(nums, k + 1, right);
        return k + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
