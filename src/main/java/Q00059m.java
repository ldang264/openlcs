/**
 * 给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= n <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00059m {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int index = 1, circle = 0, i = 0, j = 0;
        while (circle < (n + 1) / 2) {
            while (j < n - circle) { // 右界
                matrix[i][j++] = index++;
            }
            j--;
            i++;
            while (i < n - circle) { // 下界
                matrix[i++][j] = index++;
            }
            i--;
            j--;
            while (j >= circle) { // 左界
                matrix[i][j--] = index++;
            }
            j++;
            i--;
            while (i > circle) { // 上界
                matrix[i--][j] = index++;
            }
            i++;
            j++; // 转向右测，开始下一圈
            circle++;
        }
        return matrix;
    }
}
