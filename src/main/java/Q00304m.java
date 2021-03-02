/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1,col1) ，右下角为 (row2,col2) 。
 * 上图子矩阵左上角(row1, col1) = (2, 1)，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例：
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * 提示：
 * 你可以假设矩阵不可变。
 * 会多次调用sumRegion方法。
 * 你可以假设row1 ≤ row2 且col1 ≤ col2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00304m {

    private int[][] twoArray; // 二维前缀和

    public Q00304m(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        twoArray = new int[matrix.length + 1][matrix[0].length + 1]; // 扩充一行和一列，以避免边界判断
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                twoArray[i][j] = twoArray[i][j - 1] + twoArray[i - 1][j] - twoArray[i - 1][j - 1] + matrix[i - 1][j - 1]; // 横向和竖向都求和
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (twoArray == null) return 0;
        return (twoArray[row2 + 1][col2 + 1] - twoArray[row1][col2 + 1]) - (twoArray[row2 + 1][col1] - twoArray[row1][col1]);
    }

    /*
    private int[][] oneArray; // 一维前缀和

    public Q00304m(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        oneArray = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                oneArray[i][j] = oneArray[i][j - 1] + matrix[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (oneArray == null) return 0;
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += oneArray[i][col2 + 1] - oneArray[i][col1];
        }
        return sum;
    }*/
}
