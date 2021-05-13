/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1：
 * 输入：
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * 输出：
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * 示例 2：
 * 输入：
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * 输出：
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *  
 *
 * 提示：
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00542m {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n]; // 动态规划
        int MAX = m + n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    ans[i][j] = MAX; // 用最大值占位，这是通用做法
                }
            }
        }
        // 左上到右下
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (i != 0) {
                        ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
                    }
                    if (j != 0) {
                        ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
                    }
                }
            }
        }
        // 右上到左下
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    if (i != 0) {
                        ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
                    }
                    if (j != n - 1) {
                        ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
                    }
                }
            }
        }
        // 左下到右上
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (i != m - 1) {
                        ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
                    }
                    if (j != 0) {
                        ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
                    }
                }
            }
        }
        // 右下到左上
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    if (i != m - 1) {
                        ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
                    }
                    if (j != n - 1) {
                        ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
                    }
                }
            }
        }
        return ans;
    }
}
