package algorithm.sort;

import java.util.Arrays;

/**
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 4, 3, 2, 2, 1};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sort(nums)));
    }

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] sort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }
}
