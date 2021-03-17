/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 * 示例:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * 示例:
 * 输入:
 * [
 *  [ 1, 2, 3, 4 ],
 *  [ 5, 6, 7, 8 ],
 *  [ 9, 10,11,12 ]
 * ]
 * 输出:  [1,2,5,9,6,3,4,7,10,11,8,2]
 *
 * 示例:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ],
 *  [ 10,11,12 ]
 * ]
 * 输出:  [1,2,4,7,5,3,6,8,10,11,9,12]
 *
 * 说明:
 * 给定矩阵中的元素总数不会超过 100000 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00498m {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m;
        int n;
        if (matrix == null || (m = matrix.length) == 0 || (n = matrix[0].length) == 0) {
            return new int[0];
        }
        int[] ans = new int[m * n];
        int i = 0, j = 0, index = 0;
        boolean rc = true;
        while (index < ans.length) {
            if (rc) {
                while (i >= 0 && j < n) {
                    ans[index++] = matrix[i--][j++]; // 从左下到右上
                }
                if (i == -1 && j == n) { // 在右上角
                    i = 1;
                    j = n - 1;
                } else if (i == -1) { // 在上边
                    i = 0;
                } else { // 在右边
                    i += 2;
                    j--;
                }
                rc = false;
            } else {
                while (i < m && j >= 0) {
                    ans[index++] = matrix[i++][j--]; // 从右上到左下
                }
                if (i == m && j == -1) { // 在左下角
                    i = m - 1;
                    j = 1;
                } else if (i == m) { // 在下边
                    i = m - 1;
                    j += 2;
                } else { // 在左边
                    j++;
                }
                rc = true;
            }
        }
        return ans;
    }
}
