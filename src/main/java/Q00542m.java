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

    private int[][] ans; // 存储结果

    private boolean[][] visited; // 访问到的标识

    public int[][] updateMatrix(int[][] mat) {
        ans = new int[mat.length][mat[0].length];
        visited = new boolean[mat.length][mat[0].length];
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (mat[i - 1][j] == 0){

                    } else if (mat[i + 1][j] == 0) {

                    } else if (mat[i][j - 1] == 0) {

                    } else if (mat[i][j + 1] == 0) {

                    } else {

                    }
                }
            }
        }
        return ans;
    }

    private void drawColor(int[][] mat, int i, int j) {

    }
}
