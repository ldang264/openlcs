package q00056m;

import junit.framework.TestCase;

public class MergeTest extends TestCase {

    Merge m = new Merge();

    public void testMerge1() {
        int[][] intervals = new int[][]{{8,10},{15,18},{1,3},{2,6}};
        int[][] ans = m.merge(intervals);
        System.out.println(ans);
    }

    public void testMerge2() {
        int[][] intervals = new int[][]{{4,5},{1,4}};
        int[][] ans = m.merge(intervals);
        System.out.println(ans);
    }

    public void testMerge3() {
        int[][] intervals = new int[][]{{1,4},{1,5}};
        int[][] ans = m.merge(intervals);
        System.out.println(ans);
    }

    public void testMerge4() {
        int[][] intervals = new int[][]{{1,4},{2,3}};
        int[][] ans = m.merge(intervals);
        System.out.println(ans);
    }

    public void testMerge5() {
        int[][] intervals = new int[][]{{2,3},{1,4}};
        int[][] ans = m.merge(intervals);
        System.out.println(ans);
    }
}