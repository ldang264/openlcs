/**
 * 给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 示例 1：
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：下面是两条和最小的下降路径，用加粗标注：
 * [[2,1,3],      [[2,1,3],
 *  [6,5,4],       [6,5,4],
 *  [7,8,9]]       [7,8,9]]
 *
 * 示例 2：
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：下面是一条和最小的下降路径，用加粗标注：
 * [[-19,57],
 *  [-40,-5]]
 *
 * 示例 3：
 * 输入：matrix = [[-48]]
 * 输出：-48
 * 
 *
 * 提示：
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00931m {
    public int minFallingPathSum(int[][] matrix) {
        // 从第一行开始逐个去更新，新的matrix[i][j]表示选取当前值计算出的最小值
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int min = matrix[i - 1][j]; // 必取正上方的值
                if (j > 0 && matrix[i - 1][j - 1] < min) { // 可以取左上角的值
                    min = matrix[i - 1][j - 1];
                }
                if (j < matrix.length - 1 && matrix[i - 1][j + 1] < min) { // 可以取右上角的值
                    min = matrix[i - 1][j + 1];
                }
                matrix[i][j] += min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < matrix.length; j++) {
            min = Math.min(min, matrix[matrix.length - 1][j]); // 取最后一行的最小值作为最终的答案
        }
        return min;
    }
}
