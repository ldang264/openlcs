import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 *
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 * 示例 4：
 * 输入：matrix = [["1"]]
 * 输出：1
 *
 * 示例 5：
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *
 * 提示：
 *
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00085h {

    /**
     * 单调栈
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int m, n;
        if ((m = matrix.length) == 0 || (n = matrix[0].length) == 0) return 0;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    arr[i][j] = (i > 0) ? arr[i - 1][j] + 1 : 1; // 按照竖向计数
                }
            }
        }
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        int[] left = new int[n]; // 存储左边界
        int[] right = new int[n]; // 存储右边界
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                while (stack.size() > 0 && arr[i][j] < arr[i][stack.peek()]) { // 出现短板，确定右边界
                    right[stack.pop()] = j;
                }
                stack.push(j);
            }
            while (stack.size() > 0) { // 剩余的右边界都是n
                right[stack.pop()] = n;
            }
            for (int j = n - 1; j >= 0; j--) {
                while (stack.size() > 0 && arr[i][j] < arr[i][stack.peek()]) { // 出现短板，确定左边界
                    left[stack.pop()] = j;
                }
                stack.push(j);
            }
            while (stack.size() > 0) { // 剩余的都是-1
                left[stack.pop()] = -1;
            }
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, arr[i][j] * (right[j] - left[j] - 1)); // -1是因为左边界向左取了一个位置
            }
        }
        return ans;
    }

}
