package q00057h;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Interval_Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{ newInterval };
        int[][] ans = new int[intervals.length + 1][];
        int index = 0;
        int i = 0;
        for (; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) { // n=[1,2] i=[3,4]
                ans[index++] = newInterval;
                break;
            } else if (intervals[i][1] < newInterval[0]) { // n=[3,4] i=[1,2]
                ans[index++] = intervals[i];
            } else {
                if (newInterval[0] <= intervals[i][0] && newInterval[1] <= intervals[i][1]) { // n=[1,3] i=[2,4]
                    intervals[i][0] = newInterval[0];
                    break;
                } else if (newInterval[0] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) { // n=[2,3] i=[1,4]
                    break;
                } else if (newInterval[0] >= intervals[i][0] && newInterval[1] >= intervals[i][1]) { // n=[2,4] i=[1,3]
                    intervals[i][1] = newInterval[1];
                    break;
                } else if (newInterval[0] <= intervals[i][0] && newInterval[1] >= intervals[i][1]) {
                    intervals[i][0] = newInterval[0];
                    intervals[i][1] = newInterval[1];
                    break;
                }
            }
        }
        for (; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] > intervals[i][1]) { // i=[1,2] i+1=[3,4]
                ans[index++] = intervals[i];
            } else {
                intervals[i + 1][0] = intervals[i][0]; // 使用i的左区间
                if (intervals[i + 1][1] <= intervals[i][1]) { // 如果i包含i+1，则使用i的右区间
                    intervals[i + 1][1] = intervals[i][1];
                }
            }
        }
        if (newInterval[0] > intervals[intervals.length - 1][1]) { // 如果整个n都比i大，则a的最后一个是n
            ans[index++] = newInterval;
        } else {
            ans[index++] = intervals[intervals.length - 1];
        }
        int[][] realAns = new int[index][];
        for (i = 0; i < index; i++) {
            realAns[i] = ans[i];
        }
        return realAns;
    }
}
