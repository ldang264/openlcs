import java.util.*;

/**
 * 给定一个二维平面，平面上有n个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |    o
 * |   o
 * | o 
 * +------------->
 * 0 1 2 3  4
 *
 * 示例2:
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * | o      o
 * |    o
 * | o       o
 * +------------------->
 * 0 1 2 3 4 5 6
 *
 * Constraints:
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * All the points are unique.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00149h {

    public int maxPoints(int[][] points) {
        // 外层map的键是斜率；内层map的键是起点坐标的下标，值是这条直线上点的个数
        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        int ans = 1;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                String xl = getXL(points[i], points[j]);
                Map<Integer, Integer> lineMap = map.get(xl);
                Integer count;
                if (lineMap == null) {
                    lineMap = new HashMap<>();
                    map.put(xl, lineMap);
                    count = 2;
                } else {
                    count = lineMap.get(i);
                    if (count == null) {
                        count = 2;
                    } else {
                        ++count;
                    }
                }
                lineMap.put(i, count);
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    private String getXL(int[] a, int[] b) {
        // 竖线
        if (a[0] == b[0])
            return a[0] + "|";
        // 横线
        if (a[1] == b[1])
            return "0";
        // 计算斜率
        int distX = b[0] - a[0], distY = b[1] - a[1];
        if (distX == distY) return "1";
        if (distX + distY == 0) return "-1";
        int gys = distX < distY ? getGcd(distX, distY) : getGcd(distY, distX);
        return (distY / gys) + "/" + (distX / gys);
    }

    /**
     * 使用辗转相除法求最大公约数
     */
    private int getGcd(int min, int max) {
        int y;
        while ((y = max % min) != 0) {
            max = min;
            min = y;
        }
        return min;
    }
}
