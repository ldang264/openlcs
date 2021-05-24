import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Q00057mTest {

    Q00057m i = new Q00057m();

    @Test
    public void insert() {
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        String exp = "[[1, 5], [6, 9]]";
        String act = Arrays.deepToString(i.insert(intervals, newInterval));
        Assert.assertEquals(exp, act);
    }

    @Test
    public void insert1() {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{4, 8};
        String exp = "[[1, 2], [3, 10], [12, 16]]";
        String act = Arrays.deepToString(i.insert(intervals, newInterval));
        Assert.assertEquals(exp, act);
    }

    @Test
    public void insert2() {
        int[][] intervals = new int[][]{{3, 5}, {6, 7}};
        int[] newInterval = new int[]{1, 2};
        String exp = "[[1, 2], [3, 5], [6, 7]]";
        String act = Arrays.deepToString(i.insert(intervals, newInterval));
        Assert.assertEquals(exp, act);
    }

    @Test
    public void insert3() {
        int[][] intervals = new int[][]{{3, 5}, {6, 7}};
        int[] newInterval = new int[]{1, 3};
        String exp = "[[1, 5], [6, 7]]";
        String act = Arrays.deepToString(i.insert(intervals, newInterval));
        Assert.assertEquals(exp, act);
    }

    @Test
    public void insert4() {
        int[][] intervals = new int[][]{{3, 5}, {6, 7}};
        int[] newInterval = new int[]{1, 9};
        String exp = "[[1, 9]]";
        String act = Arrays.deepToString(i.insert(intervals, newInterval));
        Assert.assertEquals(exp, act);
    }

    @Test
    public void insert5() {
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{4, 8};
        String exp = "[[1, 8]]";
        String act = Arrays.deepToString(i.insert(intervals, newInterval));
        Assert.assertEquals(exp, act);
    }

    @Test
    public void insert6() {
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{6, 8};
        String exp = "[[1, 5], [6, 8]]";
        String act = Arrays.deepToString(i.insert(intervals, newInterval));
        Assert.assertEquals(exp, act);
    }
}