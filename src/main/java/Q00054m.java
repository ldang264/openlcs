import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00054m {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int circle = 0; // 圈数
        int i = 0, j = 0; // 当前下标
        while (circle < (m + 1) / 2) { // 圈数的上限
            if (j == n - circle) break; // 向右到了已经遍历过的
            while (j < n - circle) { // 向右一直加入
                ans.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            if (i == m - circle) break; // 向下到了已经遍历过的
            while (i < m - circle) { // 向下一直加入
                ans.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            if (j < circle) break; // 向左到了已经遍历过的
            while (j >= circle) { // 向左一直加入
                ans.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            if (i == circle) break; // 向上到了已经遍历过的
            while (i > circle) { // 向上一直加入
                ans.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            circle++;
        }
        return ans;
    }
}
