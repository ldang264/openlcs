/**
 * 给出一个二维数组A，每个单元格为 0（代表海）或 1（代表陆地）。
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 * 示例 1：
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释： 
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 *
 * 示例 2：
 * 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：
 * 所有 1 都在边界上或可以到达边界。
 *
 * 提示：
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * 所有行的大小都相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-enclaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01020m {

    /**
     * 染色
     * @param grid
     * @return
     */
    public int numEnclaves(int[][] grid) {
        for (int i = 1; i < grid.length - 1; i++) { // 边界第一列,去除首尾行
            if (grid[i][0] == 1) {
                grid[i][0] = 0;
                find(grid, i, 1);
            }
            if (grid[i][grid[0].length - 1] == 1) {
                grid[i][grid[0].length - 1] = 0;
                find(grid, i, grid[0].length - 2);
            }
        }
        for (int i = 0; i < grid[0].length; i++) { // 边界第一行
            if (grid[0][i] == 1) {
                grid[0][i] = 0;
                find(grid, 1, i);
            }
            if (grid[grid.length - 1][i] == 1) {
                grid[grid.length - 1][i] = 0;
                find(grid, grid.length - 2, i);
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }

    private void find(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            find(grid, i, j + 1);
            find(grid, i, j - 1);
            find(grid, i + 1, j);
            find(grid, i - 1, j);
        }
    }
}
