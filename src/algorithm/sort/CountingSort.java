package algorithm.sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 4, 3, 2, 2, 1};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sort(nums)));
    }

    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] sort(int[] array) {
        if (array.length == 0) return array;
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] - min]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i + min;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }
}
