package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 *
 * 算法描述
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 *
 * 平均时间复杂度：O(n^2) 最好：O(n) 最坏：O(n^2)
 * 空间复杂度：O(1)
 * 是否占用额外内存：否
 * 是否稳定：是
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 4, 3, 2, 2, 1};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sort(nums)));
    }
    /**
     *
     * @param nums
     */
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        for (int i = 1, j, current; i < nums.length; i++) {
            current = nums[i];
            for (j = i - 1; j >= 0 && current < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = current;
        }
        return nums;
    }
}
