package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void sort1() {
        int[] nums = new int[]{1, 4, 6, 2, 4, 1, 3, 5};
        Assert.assertEquals("[1, 1, 2, 3, 4, 4, 5, 6]", Arrays.toString(SelectionSort.sort(nums)));
    }

    @Test
    public void sort2() {
        int[] nums = new int[]{3, 2};
        Assert.assertEquals("[2, 3]", Arrays.toString(SelectionSort.sort(nums)));
    }
}