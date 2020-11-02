package q00056m;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *  
 *
 * 提示：
 *
 * intervals[i][0] <= intervals[i][1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        int[][] ans = new int[intervals.length][];
        sort(intervals,0, intervals.length - 1);
        int index = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] prev = intervals[i];
            int[] next = intervals[i + 1];
            if (prev[1] < next[0]) { // 如果前一个右区间小于后一个左区间，则加入结果
                ans[index++] = prev;
            } else {
                next[0] = prev[0]; // 合并左区间
                if (next[1] < prev[1]) { // 如果的右区间后一个小于前一个右区间，则前面完全包含后面
                    next[1] = prev[1]; // 则取前一个的右区间
                }
            }
        }
        ans[index++] = intervals[intervals.length - 1];
        int[][] realAns = new int[index][];
        for (int i = 0; i < index; i++) {
            realAns[i] = ans[i];
        }
        return realAns;
    }

    /**
     * 快速排序
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int[][] sort(int[][] array, int start, int end) {
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
    private static int partition(int[][] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i][0] <= array[end][0]) {
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
    private static void swap(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
