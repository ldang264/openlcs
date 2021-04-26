/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length<= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class J00029s {
    public int[] spiralOrder(int[][] matrix) {
        int m, n;
        if ((m = matrix.length) == 0 || (n = matrix[0].length) == 0) return new int[0];
        int[] ans = new int[m * n];
        int circle = (Math.min(m, n) + 1) / 2, i = 0, j = 0, k = 0, index = 0;
        while (k < circle) {
            if (j == n - k) break;
            while (j < n - k) {
                ans[index++] = matrix[i][j];
                j++;
            }
            j--;
            i++;
            if (i == m - k) break;
            while (i < m - k) {
                ans[index++] = matrix[i][j];
                i++;
            }
            i--;
            j--;
            if (j < k) break;
            while (j >= k) {
                ans[index++] = matrix[i][j];
                j--;
            }
            j++;
            i--;
            if (i == k) break;
            while (i > k) {
                ans[index++] = matrix[i][j];
                i--;
            }
            i++;
            j++;
            k++;
        }
        return ans;
    }
}
