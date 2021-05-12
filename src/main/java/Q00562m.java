/**
 * 给定一个01矩阵 M，找到矩阵中最长的连续1线段。这条线段可以是水平的、垂直的、对角线的或者反对角线的。
 *
 * 示例:
 * 输入:
 * [[0,1,1,0],
 *  [0,1,1,0],
 *  [0,0,0,1]]
 * 输出: 3
 * 提示: 给定矩阵中的元素数量不会超过 10,000。
 *
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-line-of-consecutive-one-in-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-line-of-consecutive-one-in-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00562m {
    public int longestLine(int[][] mat) {
        int m = mat.length, n = mat[0].length, ans = 0, x, y;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (j == 0 || mat[i][j - 1] == 0) { // 行：最左界或者左侧是0
                        y = j + 1;
                        while (y < n && mat[i][y] == 1) {
                            y++;
                        }
                        ans = Math.max(ans, y - j);
                    }
                    if (i == 0 || mat[i - 1][j] == 0) { // 列：最上界或者上边是0
                        x = i + 1;
                        while (x < m && mat[x][j] == 1) {
                            x++;
                        }
                        ans = Math.max(ans, x - i);
                    }
                    if (i == 0 || j == 0 || mat[i - 1][j - 1] == 0) { // 左上到右下：最左界或者最上界或者左上元素是0
                       x = i + 1; y = j + 1;
                       while (x < m && y < n && mat[x][y] == 1) {
                           x++;
                           y++;
                       }
                       ans = Math.max(ans, x - i);
                    }
                    if (i == 0 || j == n - 1 || mat[i - 1][j + 1] == 0) { // 右上到左下：最上界或者最右界或者右上元素是0
                        x = i + 1; y = j - 1;
                        while (x < m && y >= 0 && mat[x][y] == 1) {
                            x++;
                            y--;
                        }
                        ans = Math.max(ans, x - i);
                    }
                }
            }
        }
        return ans;
    }
}
