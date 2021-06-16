import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 * 示例 1：
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 *
 * 示例 2：
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *
 * 提示：
 * 2 <= timePoints <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00539m {

    public int findMinDifference(List<String> timePoints) {
        boolean[] mins = new boolean[1440]; // 下标映射一天当中所有的分钟时刻
        for (String timePoint : timePoints) {
            int min = toMin(timePoint);
            if (mins[min]) return 0; // 该时刻已存在，返回0
            mins[min] = true;
        }
        int ans = 1439, start = -1, end = -1;
        for (int i = 0; i < mins.length; i++) {
            if (mins[i]) {
                if (start == -1) {
                    start = i; // 开始时刻
                }
                if (end != -1) {
                    ans = Math.min(ans, i - end); // 更新前后差值
                }
                end = i; // 不断更新结束时刻
            }
        }
        return Math.min(ans, start + 1440 - end);
    }

    /*
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < timePoints.size(); i++) {
            list.add(toMin(timePoints.get(i)));
        }
        Collections.sort(list);
        int min = list.get(0) + 1440 - list.get(list.size() - 1);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    */
    private int toMin(String hhmm) {
        return ((hhmm.charAt(0) - '0') * 10 + (hhmm.charAt(1) - '0')) * 60 +
                ((hhmm.charAt(3) - '0') * 10 + (hhmm.charAt(4) - '0'));
    }
}
