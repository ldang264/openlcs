/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q00074m {

    private boolean find;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        find = false;
        int row;
        if (matrix[matrix.length - 1][0] <= target && target <= matrix[matrix.length - 1][matrix[0].length - 1]) {
            row = matrix.length - 1;
        } else {
            // 两次二分查找
            // 先找到它所在的行
            row = findRow(matrix, 0, matrix.length - 1, target);
            if (find) return true;
            if (row == -1) return false;
        }
        // 再找到它所在位置
        findColumn(matrix[row], 0, matrix[row].length - 1, target);
        return find;
    }

    private int findRow(int[][] matrix, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (matrix[mid][0] == target) {
            find = true;
            return mid;
        }
        if (matrix[mid][0] < target) {
            if (mid >= end) return -1;
            if (matrix[mid + 1][0] > target) {
                return mid;
            }
            return findRow(matrix, mid + 1, end, target);
        } else {
            if (mid <= 0) return -1;
            if (matrix[mid - 1][0] < target) {
                return mid - 1;
            }
            return findRow(matrix, start, mid - 1, target);
        }
    }

    private void findColumn(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            find = true;
            return;
        }
        if (nums[mid] < target) {
            if (mid >= end) return;
            findColumn(nums, mid + 1, end, target);
        } else {
            if (mid <= 0) return;
            findColumn(nums, start, mid - 1, target);
        }
    }
}
