package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
/**
* 快速排序测试用例
*/
public class QuickSortTest {

    @Test
    public void sort1() {
        int[] nums = new int[]{5, 4, 4, 3, 2, 2, 1};
        Assert.assertEquals("[1, 2, 2, 3, 4, 4, 5]", Arrays.toString(QuickSort.sort(nums)));
    }

    @Test
    public void sort2() {
        int[] nums = new int[]{1, 4, 5, 3, 6, 2, 3};
        Assert.assertEquals("[1, 2, 3, 3, 4, 5, 6]", Arrays.toString(QuickSort.sort(nums)));
    }
}
