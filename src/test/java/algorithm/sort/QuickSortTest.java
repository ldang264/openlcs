package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void sort1() {
        int[] nums = new int[]{5, 4, 4, 3, 2, 2, 1};
        Assert.assertEquals("[1, 2, 2, 3, 4, 4, 5]", Arrays.toString(QuickSort.sort(nums, 0, nums.length - 1)));
    }

    @Test
    public void sort2() {
        int[] nums = new int[]{1, 4, 5, 3, 6, 2, 3};
        Assert.assertEquals("[1, 2, 3, 3, 4, 5, 6]", Arrays.toString(QuickSort.sort(nums, 0, nums.length - 1)));
    }
}