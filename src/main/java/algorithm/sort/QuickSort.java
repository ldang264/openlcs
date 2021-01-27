package algorithm.sort;

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
public class QuickSort {

    public static int[] sort(int[] array, int start, int end) {
        if (start < 0 || end >= array.length || start > end) return null;
        // 对数组array[start...end]进行分割，返回中轴元素下标
        int j = partition(array, start, end);
        // 对左子数组array[start...j-1]进行快速排序
        sort(array, start, j - 1);
        // 对右子数组array[j+1...high]进行快速排序
        sort(array, j + 1, end);
        return array;
    }

    /**
     * 快速排序算法——partition
     * 选出中轴元素，将数组array[start...end]分割为3部分
     * array[start...j-1] <= array[j] <= array[j+1...end]
     * @param array
     * @param start
     * @param end
     * @return 中轴元素的下标
     */
    private static int partition(int[] array, int start, int end) {
        int i = start, j = end + 1; // 左右扫描指针
        // i、j扫描数组
        while (true) {
            // 遇到大于等于中轴元素时跳出
            while (array[++i] < array[start]) {
                if (i == end) break;
            }
            // 遇到小于等于中轴元素时跳出
            while (array[--j] > array[start]) {
                if (j == start) break;
            }
            // 如果i>=j跳出
            if (i >= j) break;
            // 如果i<j则交换i与j，继续扫描
            swap(array, i, j);
        }
        swap(array, start, j); // 将中轴元素交换到排好序的位置，分割结束
        return j;
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
