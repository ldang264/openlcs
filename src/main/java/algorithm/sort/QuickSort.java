package algorithm.sort;

import java.util.Arrays;

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

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{5, 4, 4, 3, 2, 2, 1};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sort(nums, 0, nums.length - 1)));
    }

    public static <T> Comparable<T>[] sort(Comparable<T>[] array, int start, int end) {
        if (start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            sort(array, start, smallIndex - 1);
        if (smallIndex < end)
            sort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * 快速排序算法——partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static <T> int partition(Comparable<T>[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i].compareTo((T) array[end]) <= 0) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static <T> void swap(Comparable<T>[] array, int i, int j) {
        Comparable<T> temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
