package q00056m;

import java.util.Arrays;
import java.util.Comparator;

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
public class Interval_Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        int[][] ans = new int[intervals.length][];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
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
}
