

/**
 * 给定一个m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例1:
 * 输入: 
 * [
 *  [1,1,1],
 *  [1,0,1],
 *  [1,1,1]
 * ]
 * 输出: 
 * [
 *  [1,0,1],
 *  [0,0,0],
 *  [1,0,1]
 * ]
 *
 * 示例2:
 * 输入: 
 * [
 *  [0,1,2,0],
 *  [3,4,5,2],
 *  [1,3,1,5]
 * ]
 * 输出: 
 * [
 *  [0,0,0,0],
 *  [0,4,5,0],
 *  [0,3,1,0]
 * ]
 *
 * 进阶:
 * 一个直接的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00073m {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean first = false; // 标记第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) first = true; // 第一列本来就有0，那在后面全置为0
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
            }
        }
        for (int i = m - 1; i >= 0; i--) { // 行反过来处理的原因是不受前面更新第一列的影响
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            if (first) matrix[i][0] = 0;
        }
    }
}
